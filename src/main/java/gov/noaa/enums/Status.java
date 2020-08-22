package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Status {
  
  ACTUAL("Actual","actual"),
  EXERCISE("Exercise","exercise"),
  SYSTEM("System","system"),
  TEST("Test","test"),
  DRAFT("Draft","draft");
  @JsonValue
  private String uppercase;
  
  private String lowercase;
  
  Status(String uppercase, String lowercase) {
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }
}
