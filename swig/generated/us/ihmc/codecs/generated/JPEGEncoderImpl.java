/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.codecs.generated;

public class JPEGEncoderImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected JPEGEncoderImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(JPEGEncoderImpl obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ihmcVideoCodecsJNI.delete_JPEGEncoderImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public JPEGEncoderImpl() {
    this(ihmcVideoCodecsJNI.new_JPEGEncoderImpl(), true);
  }

  public long maxSize(YUVPicture pic) {
    return ihmcVideoCodecsJNI.JPEGEncoderImpl_maxSize(swigCPtr, this, YUVPicture.getCPtr(pic), pic);
  }

  public int encode(YUVPicture pic, java.nio.ByteBuffer target, int targetLength, int quality) {
  assert target.isDirect() : "Buffer must be allocated direct.";
    {
      return ihmcVideoCodecsJNI.JPEGEncoderImpl_encode(swigCPtr, this, YUVPicture.getCPtr(pic), pic, target, targetLength, quality);
    }
  }

}
