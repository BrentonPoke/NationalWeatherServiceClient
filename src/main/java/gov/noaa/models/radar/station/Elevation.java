package gov.noaa.models.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Elevation{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("value")
	private Integer value;
}