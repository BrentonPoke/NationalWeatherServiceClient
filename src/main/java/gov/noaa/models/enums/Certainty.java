package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.extern.log4j.Log4j2;

@Log4j2
public enum Certainty {
  
  UNKNOWN("Unknown","unknown"),
  UNLIKELY("Unlikely","unlikely"),
  POSSIBLE("Possible","possible"),
  LIKELY("Likely","likely"),
  OBSERVED("Observed","observed");
  private String uppercase;
  
  private String lowercase;
  private static ImmutableMap.Builder<String, Certainty> CONSTANTS = ImmutableMap.builder();
  
  static {
    for (Certainty c: values()) {
     CONSTANTS.put(c.lowercase, c);
    }
  }
  
  Certainty(String uppercase, String lowercase) {
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }
  
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Certainty valueFromLowercase(String value) {
    Certainty constant = CONSTANTS.build().get(value);
    if (constant == null) {
      log.error("Couldn't get constant from {}: {} not found",this.getClass().getName(),value);
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
  
}