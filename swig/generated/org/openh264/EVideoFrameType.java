/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.openh264;

public enum EVideoFrameType {
  videoFrameTypeInvalid,
  videoFrameTypeIDR,
  videoFrameTypeI,
  videoFrameTypeP,
  videoFrameTypeSkip,
  videoFrameTypeIPMixed;

  public final int swigValue() {
    return swigValue;
  }

  public static EVideoFrameType swigToEnum(int swigValue) {
    EVideoFrameType[] swigValues = EVideoFrameType.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (EVideoFrameType swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + EVideoFrameType.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private EVideoFrameType() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private EVideoFrameType(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private EVideoFrameType(EVideoFrameType swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
