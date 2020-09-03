package gov.noaa.models.stations.observations.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxTemperatureLast24Hours{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("qualityControl")
	private String qualityControl;

	@JsonProperty("value")
	private Float value;
}