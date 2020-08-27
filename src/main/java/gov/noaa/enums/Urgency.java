package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Urgency {
  
  UNKNOWN("Unknown","unknown"),
  PAST("Past","past"),
  FUTURE("Future","future"),
  EXPECTED("Expected","expected"),
  IMMEDIATE("Immediate","immediate");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Urgency> CONSTANTS;
  
  static {
    for (Urgency c: values()) {
      CONSTANTS = ImmutableMap.<String, Urgency>builder().put(c.lowercase, c);
    }
  }
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Urgency valueFromLowercase(String value) {
    Urgency constant = CONSTANTS.build().get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
