package gov.noaa.stations.observations.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxTemperatureLast24Hours{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("qualityControl")
	private Object qualityControl;

	@JsonProperty("value")
	private Float value;
}