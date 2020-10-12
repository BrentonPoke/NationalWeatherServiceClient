package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RegionType {
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
  
  RegionType(String value) {
    this.value = value;
  }
  @Override
  public String toString() {
    return this.value;
  }
}
