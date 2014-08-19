/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class SDeliveryStatus {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SDeliveryStatus(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SDeliveryStatus obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SDeliveryStatus(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIDropNum(int value) {
    codec_apiJNI.SDeliveryStatus_iDropNum_set(swigCPtr, this, value);
  }

  public int getIDropNum() {
    return codec_apiJNI.SDeliveryStatus_iDropNum_get(swigCPtr, this);
  }

  public void setIDropFrameType(int value) {
    codec_apiJNI.SDeliveryStatus_iDropFrameType_set(swigCPtr, this, value);
  }

  public int getIDropFrameType() {
    return codec_apiJNI.SDeliveryStatus_iDropFrameType_get(swigCPtr, this);
  }

  public void setIDropFrameSize(int value) {
    codec_apiJNI.SDeliveryStatus_iDropFrameSize_set(swigCPtr, this, value);
  }

  public int getIDropFrameSize() {
    return codec_apiJNI.SDeliveryStatus_iDropFrameSize_get(swigCPtr, this);
  }

  public SDeliveryStatus() {
    this(codec_apiJNI.new_SDeliveryStatus(), true);
  }

}
