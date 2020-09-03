package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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
  public static MessageType valueFromLowercase(String value) {
    MessageType constant = CONSTANTS.build().get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}