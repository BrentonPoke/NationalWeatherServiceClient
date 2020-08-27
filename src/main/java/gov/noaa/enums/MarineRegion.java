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
  PI("PI"),
  AR("AR"),
  CR("CR"),
  ER("ER"),
  PR("PR"),
  SR("SR"),
  WR("WR");
  private final String value;
}
