package gov.noaa.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;

@Getter
public enum MessageType {
  
  ALERT("Alert","alert"),
  UPDATE("Update","update"),
  CANCEL("Cancel","cancel");
  @JsonValue
  private String uppercase;
  private String lowercase;
  private static ImmutableMap.Builder<String, MessageType> CONSTANTS;
  
  static {
    for (MessageType c: values()) {
      CONSTANTS = ImmutableMap.<String, MessageType>builder().put(c.lowercase, c);
    }
  }
  MessageType(String uppercase, String lowercase) {
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }
  public static MessageType valueFromLowercase(String value) {
    MessageType constant = CONSTANTS.build().get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}