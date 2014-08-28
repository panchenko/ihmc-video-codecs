/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openh264;

public class SLayerBSInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SLayerBSInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SLayerBSInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        codec_apiJNI.delete_SLayerBSInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUiTemporalId(short value) {
    codec_apiJNI.SLayerBSInfo_uiTemporalId_set(swigCPtr, this, value);
  }

  public short getUiTemporalId() {
    return codec_apiJNI.SLayerBSInfo_uiTemporalId_get(swigCPtr, this);
  }

  public void setUiSpatialId(short value) {
    codec_apiJNI.SLayerBSInfo_uiSpatialId_set(swigCPtr, this, value);
  }

  public short getUiSpatialId() {
    return codec_apiJNI.SLayerBSInfo_uiSpatialId_get(swigCPtr, this);
  }

  public void setUiQualityId(short value) {
    codec_apiJNI.SLayerBSInfo_uiQualityId_set(swigCPtr, this, value);
  }

  public short getUiQualityId() {
    return codec_apiJNI.SLayerBSInfo_uiQualityId_get(swigCPtr, this);
  }

  public void setUiLayerType(short value) {
    codec_apiJNI.SLayerBSInfo_uiLayerType_set(swigCPtr, this, value);
  }

  public short getUiLayerType() {
    return codec_apiJNI.SLayerBSInfo_uiLayerType_get(swigCPtr, this);
  }

  public void setINalCount(int value) {
    codec_apiJNI.SLayerBSInfo_iNalCount_set(swigCPtr, this, value);
  }

  public int getINalCount() {
    return codec_apiJNI.SLayerBSInfo_iNalCount_get(swigCPtr, this);
  }

  public int getPBsBufSize() {
    return codec_apiJNI.SLayerBSInfo_getPBsBufSize(swigCPtr, this);
  }

  public void getPBsBuf(java.nio.ByteBuffer target) {
  assert target.isDirect() : "Buffer must be allocated direct.";
    {
      codec_apiJNI.SLayerBSInfo_getPBsBuf(swigCPtr, this, target);
    }
  }

  public int getNalLengthInByte(int nal) {
    return codec_apiJNI.SLayerBSInfo_getNalLengthInByte(swigCPtr, this, nal);
  }

  public void getNal(int nal, java.nio.ByteBuffer target) {
  assert target.isDirect() : "Buffer must be allocated direct.";
    {
      codec_apiJNI.SLayerBSInfo_getNal(swigCPtr, this, nal, target);
    }
  }

  public SLayerBSInfo() {
    this(codec_apiJNI.new_SLayerBSInfo(), true);
  }

}