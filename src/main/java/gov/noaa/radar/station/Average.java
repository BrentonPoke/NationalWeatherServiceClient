package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Average{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("value")
	private Double value;
}