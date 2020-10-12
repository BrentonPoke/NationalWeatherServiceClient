package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
public enum Severity {
  
  UNKNOWN("Unknown","unknown"),
  MINOR("Minor","minor"),
  MODERATE("Moderate","moderate"),
  SEVERE("Severe","severe"),
  EXTREME("Extreme","extreme");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Severity> CONSTANTS = ImmutableMap.builder();
  
  static {
    for (Severity c: values()) {
      CONSTANTS.put(c.lowercase, c);
    }
  }
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Severity valueFromLowercase(String value) {
    Severity constant = CONSTANTS.build().get(value);
    if (constant == null) {
      log.error("Couldn't get constant from {}: {} not found",this.getClass().getName(),value);
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
