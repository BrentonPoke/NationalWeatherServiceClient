package gov.noaa.models.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageTransmitterPower{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("value")
	private Integer value;
}