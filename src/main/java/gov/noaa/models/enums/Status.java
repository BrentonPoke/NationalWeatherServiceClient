package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
public enum Status {
  
  ACTUAL("Actual","actual"),
  EXERCISE("Exercise","exercise"),
  SYSTEM("System","system"),
  TEST("Test","test"),
  DRAFT("Draft","draft");
  @JsonValue
  private String uppercase;
  
  private String lowercase;
  
  private static ImmutableMap.Builder<String, Status> CONSTANTS = ImmutableMap.builder();
  
  static {
    for (Status c: values()) {
      CONSTANTS.put(c.lowercase, c);
    }
  }
  @JsonValue
  public String value() {
    return this.uppercase;
  }
  
  public Status valueFromLowercase(String value) {
    Status constant = CONSTANTS.build().get(value);
    if (constant == null) {
      log.error("Couldn't get constant from {}: {} not found",this.getClass().getName(),value);
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
