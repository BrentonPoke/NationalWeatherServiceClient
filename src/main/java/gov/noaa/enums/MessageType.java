package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
  
  ALERT("alert"),
  UPDATE("update"),
  CANCEL("cancel");
  @JsonValue
  private final String value;
  
  MessageType(String value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return this.value;
  }
  
}