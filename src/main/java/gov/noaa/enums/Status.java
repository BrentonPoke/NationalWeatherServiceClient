package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
  
  ACTUAL("Actual"),
  EXERCISE("Exercise"),
  SYSTEM("System"),
  TEST("Test"),
  DRAFT("Draft");
  @JsonValue
  private final String value;
  
  Status(String value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return this.value;
  }
  
}
