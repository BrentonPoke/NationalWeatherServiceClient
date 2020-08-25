package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
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
  @JsonValue
  private String uppercase;
  
  private String lowercase;
}
