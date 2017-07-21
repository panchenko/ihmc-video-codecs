/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.codecs.generated;

public enum RC_MODES {
  RC_QUALITY_MODE(0),
  RC_BITRATE_MODE(1),
  RC_BUFFERBASED_MODE(2),
  RC_OFF_MODE(-1);

  public final int swigValue() {
    return swigValue;
  }

  public static RC_MODES swigToEnum(int swigValue) {
    RC_MODES[] swigValues = RC_MODES.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (RC_MODES swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + RC_MODES.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private RC_MODES() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private RC_MODES(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private RC_MODES(RC_MODES swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

