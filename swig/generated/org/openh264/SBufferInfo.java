/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openh264;

public class SBufferInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SBufferInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SBufferInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SBufferInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIBufferStatus(int value) {
    codec_apiJNI.SBufferInfo_iBufferStatus_set(swigCPtr, this, value);
  }

  public int getIBufferStatus() {
    return codec_apiJNI.SBufferInfo_iBufferStatus_get(swigCPtr, this);
  }

  public SSysMEMBuffer getUsrData() {
    long cPtr = codec_apiJNI.SBufferInfo_getUsrData(swigCPtr, this);
    return (cPtr == 0) ? null : new SSysMEMBuffer(cPtr, false);
  }

  public SBufferInfo() {
    this(codec_apiJNI.new_SBufferInfo(), true);
  }

}