package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  
  ACTUAL("Actual","actual"),
  EXERCISE("Exercise","exercise"),
  SYSTEM("System","system"),
  TEST("Test","test"),
  DRAFT("Draft","draft");
  @JsonValue
  private String uppercase;
  
  private String lowercase;
}
