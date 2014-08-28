/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openh264;

public class SSliceArgument {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SSliceArgument(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SSliceArgument obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SSliceArgument(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUiSliceMbNum(long[] value) {
    codec_apiJNI.SSliceArgument_uiSliceMbNum_set(swigCPtr, this, value);
  }

  public long[] getUiSliceMbNum() {
    return codec_apiJNI.SSliceArgument_uiSliceMbNum_get(swigCPtr, this);
  }

  public void setUiSliceNum(long value) {
    codec_apiJNI.SSliceArgument_uiSliceNum_set(swigCPtr, this, value);
  }

  public long getUiSliceNum() {
    return codec_apiJNI.SSliceArgument_uiSliceNum_get(swigCPtr, this);
  }

  public void setUiSliceSizeConstraint(long value) {
    codec_apiJNI.SSliceArgument_uiSliceSizeConstraint_set(swigCPtr, this, value);
  }

  public long getUiSliceSizeConstraint() {
    return codec_apiJNI.SSliceArgument_uiSliceSizeConstraint_get(swigCPtr, this);
  }

  public SSliceArgument() {
    this(codec_apiJNI.new_SSliceArgument(), true);
  }

}