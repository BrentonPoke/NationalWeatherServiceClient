package gov.noaa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarineRegion {
  
  AL("AL"),
  AT("AT"),
  GL("GL"),
  GM("GM"),
  PA("PA"),
  PI("PI");
  private final String value;
}
