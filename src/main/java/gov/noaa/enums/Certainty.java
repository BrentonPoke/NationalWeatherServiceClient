package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;

public enum Certainty {
  
  UNKNOWN("Unknown","unknown"),
  UNLIKELY("Unlikely","unlikely"),
  POSSIBLE("Possible","possible"),
  LIKELY("Likely","likely"),
  OBSERVED("Observed","observed");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Certainty> CONSTANTS;
  
  static {
    for (Certainty c: values()) {
     CONSTANTS = ImmutableMap.<String, Certainty>builder().put(c.lowercase, c);
    }
  }
  
  private Certainty(String uppercase, String lowercase) {
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }
  
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public static Certainty valueFromLowercase(String value) {
    Certainty constant = CONSTANTS.build().get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
  
}