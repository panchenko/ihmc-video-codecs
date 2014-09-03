/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.google.code.libyuv;

public enum JpegSubsamplingType {
  kJpegYuv420,
  kJpegYuv422,
  kJpegYuv411,
  kJpegYuv444,
  kJpegYuv400,
  kJpegUnknown;

  public final int swigValue() {
    return swigValue;
  }

  public static JpegSubsamplingType swigToEnum(int swigValue) {
    JpegSubsamplingType[] swigValues = JpegSubsamplingType.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (JpegSubsamplingType swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + JpegSubsamplingType.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private JpegSubsamplingType() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private JpegSubsamplingType(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private JpegSubsamplingType(JpegSubsamplingType swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

