package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Elevation{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("value")
	private Integer value;
}