/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public enum ECOMPLEXITY_MODE {
  LOW_COMPLEXITY,
  MEDIUM_COMPLEXITY,
  HIGH_COMPLEXITY;

  public final int swigValue() {
    return swigValue;
  }

  public static ECOMPLEXITY_MODE swigToEnum(int swigValue) {
    ECOMPLEXITY_MODE[] swigValues = ECOMPLEXITY_MODE.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (ECOMPLEXITY_MODE swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + ECOMPLEXITY_MODE.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private ECOMPLEXITY_MODE() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private ECOMPLEXITY_MODE(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private ECOMPLEXITY_MODE(ECOMPLEXITY_MODE swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

