/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.codecs.screenCapture;

public class ScreenShot {
  public static int getPixels(java.nio.ByteBuffer pixels, int x, int y, int width, int height) {
  assert pixels.isDirect() : "Buffer must be allocated direct.";
    {
      return ScreenShotJNI.getPixels(pixels, x, y, width, height);
    }
  }

}
