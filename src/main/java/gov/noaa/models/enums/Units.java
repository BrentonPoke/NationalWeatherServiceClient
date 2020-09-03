package gov.noaa.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Units {
  
  US("us"),
  SI("si");
  @JsonValue
  private final String value;
}
