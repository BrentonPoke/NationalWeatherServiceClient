package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Severity {
  
  UNKNOWN("Unkown","unknown"),
  MINOR("Minor","minor"),
  MODERATE("Moderate","moderate"),
  SEVERE("Severe","severe"),
  EXTREME("Extreme","extreme");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Severity> CONSTANTS;
  
  static {
    for (Severity c: values()) {
      CONSTANTS = ImmutableMap.<String, Severity>builder().put(c.lowercase, c);
    }
  }
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Severity valueFromLowercase(String value) {
    Severity constant = CONSTANTS.build().get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
