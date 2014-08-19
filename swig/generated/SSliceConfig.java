/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class SSliceConfig {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SSliceConfig(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SSliceConfig obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SSliceConfig(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUiSliceMode(SliceModeEnum value) {
    codec_apiJNI.SSliceConfig_uiSliceMode_set(swigCPtr, this, value.swigValue());
  }

  public SliceModeEnum getUiSliceMode() {
    return SliceModeEnum.swigToEnum(codec_apiJNI.SSliceConfig_uiSliceMode_get(swigCPtr, this));
  }

  public void setSSliceArgument(SSliceArgument value) {
    codec_apiJNI.SSliceConfig_sSliceArgument_set(swigCPtr, this, SSliceArgument.getCPtr(value), value);
  }

  public SSliceArgument getSSliceArgument() {
    long cPtr = codec_apiJNI.SSliceConfig_sSliceArgument_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SSliceArgument(cPtr, false);
  }

  public SSliceConfig() {
    this(codec_apiJNI.new_SSliceConfig(), true);
  }

}
