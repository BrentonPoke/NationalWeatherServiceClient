package gov.noaa.models.enums;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ZoneType {
  LAND("land"),
  MARINE("marine"),
  FORECAST("forecast"),
  PUBLIC("public"),
  COASTAL("coastal"),
  OFFSHORE("offshore"),
  FIRE("fire"),
  COUNTY("county");
  @JsonValue
  private final String value;
}