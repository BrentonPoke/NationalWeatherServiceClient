package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
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
  @JsonValue
  private String uppercase;
  
  private String lowercase;
}
