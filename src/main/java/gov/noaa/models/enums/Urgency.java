package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
@AllArgsConstructor
public enum Urgency {
  
  UNKNOWN("Unknown","unknown"),
  PAST("Past","past"),
  FUTURE("Future","future"),
  EXPECTED("Expected","expected"),
  IMMEDIATE("Immediate","immediate");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Urgency> CONSTANTS = ImmutableMap.builder();
  
  static {
    for (Urgency c: values()) {
      CONSTANTS.put(c.lowercase, c);
    }
  }
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Urgency valueFromLowercase(String value) {
    Urgency constant = CONSTANTS.build().get(value);
    if (constant == null) {
      log.error("Couldn't get constant from {}: {} not found",this.getClass().getName(),value);
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
