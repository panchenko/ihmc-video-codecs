/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class SDecodingParam {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SDecodingParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SDecodingParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SDecodingParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPFileNameRestructed(String value) {
    codec_apiJNI.SDecodingParam_pFileNameRestructed_set(swigCPtr, this, value);
  }

  public String getPFileNameRestructed() {
    return codec_apiJNI.SDecodingParam_pFileNameRestructed_get(swigCPtr, this);
  }

  public void setEOutputColorFormat(EVideoFormatType value) {
    codec_apiJNI.SDecodingParam_eOutputColorFormat_set(swigCPtr, this, value.swigValue());
  }

  public EVideoFormatType getEOutputColorFormat() {
    return EVideoFormatType.swigToEnum(codec_apiJNI.SDecodingParam_eOutputColorFormat_get(swigCPtr, this));
  }

  public void setUiCpuLoad(long value) {
    codec_apiJNI.SDecodingParam_uiCpuLoad_set(swigCPtr, this, value);
  }

  public long getUiCpuLoad() {
    return codec_apiJNI.SDecodingParam_uiCpuLoad_get(swigCPtr, this);
  }

  public void setUiTargetDqLayer(short value) {
    codec_apiJNI.SDecodingParam_uiTargetDqLayer_set(swigCPtr, this, value);
  }

  public short getUiTargetDqLayer() {
    return codec_apiJNI.SDecodingParam_uiTargetDqLayer_get(swigCPtr, this);
  }

  public void setEEcActiveIdc(ERROR_CON_IDC value) {
    codec_apiJNI.SDecodingParam_eEcActiveIdc_set(swigCPtr, this, value.swigValue());
  }

  public ERROR_CON_IDC getEEcActiveIdc() {
    return ERROR_CON_IDC.swigToEnum(codec_apiJNI.SDecodingParam_eEcActiveIdc_get(swigCPtr, this));
  }

  public void setSVideoProperty(SVideoProperty value) {
    codec_apiJNI.SDecodingParam_sVideoProperty_set(swigCPtr, this, SVideoProperty.getCPtr(value), value);
  }

  public SVideoProperty getSVideoProperty() {
    long cPtr = codec_apiJNI.SDecodingParam_sVideoProperty_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SVideoProperty(cPtr, false);
  }

  public SDecodingParam() {
    this(codec_apiJNI.new_SDecodingParam(), true);
  }

}
