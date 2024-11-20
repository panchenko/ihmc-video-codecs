package us.ihmc.codecs.loader;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

public class OpenH264Downloader
{
   public static final String openH264Version = "1.7.0";
   
   private static final String repository = "http://ciscobinary.openh264.org/";
   private static final String ext = ".bz2";

   public static final String android = "libopenh264-" + openH264Version + "-android19.so";
   public static final String linux32 = "libopenh264-" + openH264Version + "-linux32.4.so";
   public static final String linux64 = "libopenh264-" + openH264Version + "-linux64.4.so";
   public static final String osx32 = "libopenh264-" + openH264Version + "-osx32.4.dylib";
   public static final String osx64 = "libopenh264-" + openH264Version + "-osx64.4.dylib";
   public static final String win32 = "openh264-" + openH264Version + "-win32.dll";
   public static final String win64 = "openh264-" + openH264Version + "-win64.dll";

   public static final String osxDisk = "libopenh264.4.dylib";
   public static final String linuxDisk = "libopenh264.so.4";
   public static final String winDisk = "openh264.dll";

   private static boolean openH264HasBeenLoaded;

   private OpenH264Downloader()
   {
      //Disallow construction
   }

   public static String getLibraryName()
   {
      if (NativeLibraryLoader.isX86_64())
      {
         if (NativeLibraryLoader.isLinux())
         {
            return linux64;
         }
         else if (NativeLibraryLoader.isMac())
         {
            return osx64;
         }
         else if (NativeLibraryLoader.isWindows())
         {
            return win64;
         }
      }
      else
      // assume 32 bit
      {
         if (NativeLibraryLoader.isLinux())
         {
            return linux32;
         }
         else if (NativeLibraryLoader.isMac())
         {
            return osx32;
         }
         else if (NativeLibraryLoader.isWindows())
         {
            return win32;
         }
      }
      throw new RuntimeException("Cannot load archive for " + System.getProperty("os.name") + "/" + System.getProperty("os.arch"));
   }

   public static String getLibraryOnDiskName()
   {
      if (NativeLibraryLoader.isLinux())
      {
         return linuxDisk;
      }
      else if (NativeLibraryLoader.isMac())
      {
         return osxDisk;
      }
      else if (NativeLibraryLoader.isWindows())
      {
         return winDisk;
      }

      throw new RuntimeException("Cannot write archive for " + System.getProperty("os.name"));
   }

   private static void downloadOpenH264(File target, String libraryName) throws UnsatisfiedLinkError
   {
      try
      {
         URL url = getVersionURL(libraryName);
         System.out.println("Downloading " + url + " to " + target);
         InputStream remote = url.openStream();
         BZip2CompressorInputStream decompressor = new BZip2CompressorInputStream(remote);
         NativeLibraryLoader.writeStreamToFile(decompressor, target);
         remote.close();

      }
      catch (IOException e)
      {
         throw new UnsatisfiedLinkError("Cannot download OpenH264 binary " + libraryName + " to " + target + ". Are you connected to the internet?");
      }
   }

   private static URL getVersionURL(String libraryName) throws MalformedURLException
   {
      URL url = new URL(repository + libraryName + ext);
      return url;
   }

   public static void loadOpenH264() throws IOException
   {
      loadOpenH264(true);
   }

   private static synchronized void loadOpenH264(boolean showLicenseDialog)
   {
      if (openH264HasBeenLoaded)
      {
         return;
      }

      String libraryName = getLibraryName();
      File directory = new File(NativeLibraryLoader.LIBRARY_LOCATION);
      if (!directory.exists())
      {
         directory.mkdirs();
      }

      File library = new File(directory, getLibraryOnDiskName());

      if (!library.exists())
      {
         if (NativeLibraryLoader.isArm64()) {
            String resourceName = NativeLibraryLoader.isArm64() ? NativeLibraryLoader.ARM_64 + "/" + library.getName() : library.getName();
            try (InputStream stream = NativeLibraryLoader.class.getClassLoader().getResourceAsStream(resourceName)) {
               if (stream == null) {
                  throw new UnsatisfiedLinkError("OpenH264 missing in resources: " + resourceName);
               }
               Files.copy(stream, library.toPath());
            } catch (IOException e) {
               throw new RuntimeException("Error extracting " + resourceName, e);
            }
            openH264HasBeenLoaded = true;
            return;
         }
         if (showLicenseDialog)
         {
            acceptLicense();
         }
         downloadOpenH264(library, libraryName);
      }

      if (NativeLibraryLoader.isWindows())
      {
         System.load(library.getAbsolutePath());
      }

      openH264HasBeenLoaded = true;
   }

   private static void acceptLicense()
   {
      if(System.getProperty("openh264.license", "reject").equals("accept"))
      {
	     return;
      }
      else if (GraphicsEnvironment.isHeadless())
      {
         acceptLicenseConsole();
      }
      else
      {
         acceptLicenseGUI();
      }
   }

   private static void acceptLicenseGUI()
   {

      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      JTextArea license = new JTextArea(getLicenseText());
      license.setEditable(false);
      license.setLineWrap(true);
      license.setWrapStyleWord(true);
      JScrollPane scroll = new JScrollPane(license);
      scroll.setPreferredSize(new Dimension(500, 500));
      panel.add(scroll);
      panel.add(new JLabel("Do you accept the OpenH264 License?"));

      if (JOptionPane.showOptionDialog(null, panel, "OpenH264 Video Codec provided by Cisco Systems, Inc.", JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, null, null) != JOptionPane.YES_OPTION)
      {
         JOptionPane.showMessageDialog(null, "User did not accept OpenH264 license", "License not accepted", JOptionPane.ERROR_MESSAGE);
         throw new UnsatisfiedLinkError("User did accept OpenH264 license. Cannot download OpenH264 binary");
      }

   }

   private static void acceptLicenseConsole()
   {
      System.out.println("OpenH264 Video Codec provided by Cisco Systems, Inc.");
      System.out.println(getLicenseText());
      System.out.println("Do you accept the OpenH264 License? [Y/N]");

      String in = System.console().readLine();

      if (!in.toLowerCase().equals("y"))
      {
         System.err.println("License not accepted");
         throw new UnsatisfiedLinkError("User did accept OpenH264 license. Cannot download OpenH264 binary.");
      }
   }

   public static String getLicenseText()
   {
      InputStream in = OpenH264Downloader.class.getClassLoader().getResourceAsStream("OPENH264_BINARY_LICENSE.txt");
      Reader reader = new BufferedReader(new InputStreamReader(in));
      StringBuilder builder = new StringBuilder();

      try
      {
         char[] buf = new char[1024];
         int len;
         while ((len = reader.read(buf)) > 0)
         {
            builder.append(buf, 0, len);
         }

         reader.close();
         in.close();
      }
      catch (IOException e)
      {
         return e.getMessage();
      }

      return builder.toString();
   }

   /**
    * Shows an about dialog for the license with disable button, as per license terms
    * @throws IOException 
    */
   public static void showAboutCiscoDialog()
   {
      JPanel panel = new JPanel();
      panel.add(new JLabel("OpenH264 Video Codec provided by Cisco Systems, Inc."));
      panel.add(new JLabel("License terms"));

      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      JTextArea license = new JTextArea(getLicenseText());
      license.setEditable(false);
      license.setLineWrap(true);
      license.setWrapStyleWord(true);
      JScrollPane scroll = new JScrollPane(license);
      scroll.setPreferredSize(new Dimension(500, 500));
      panel.add(scroll);

      String[] options = new String[2];

      boolean enabled = isEnabled();
      if (enabled)
      {
         options[0] = "Disable Cisco OpenH264 plugin";
      }
      else
      {
         options[0] = "Enable Cisco OpenH264 plugin";
      }
      options[1] = "Close";

      int res = JOptionPane.showOptionDialog(null, panel, "OpenH264 Video Codec provided by Cisco Systems, Inc.", JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, options, null);

      if (res == 0)
      {
         if (enabled)
         {
            deleteOpenH264Library();
         }
         else
         {
            loadOpenH264(false);
         }
      }
   }

   /**
    * Check if the OpenH264 plugin is enabled
    * @return true if enabled
    */
   public static boolean isEnabled()
   {
      return new File(NativeLibraryLoader.LIBRARY_LOCATION, getLibraryOnDiskName()).exists();
   }

   /**
    * Disables the OpenH264 library, disabling the library as per license terms
    */
   public static void deleteOpenH264Library()
   {
      File library = new File(NativeLibraryLoader.LIBRARY_LOCATION, getLibraryOnDiskName());
      if (library.exists())
      {
         library.delete();
      }
   }

   public static void main(String[] args) throws MalformedURLException
   {
      System.out.println("Native libraries are located at the following URLs: ");
      
      String versions[] = {android, linux32, linux64, osx32, osx64, win32, win64};
      for(String version : versions)
      {
         System.out.println(getVersionURL(version));
      }
      
      showAboutCiscoDialog();
      
      
   }

}
