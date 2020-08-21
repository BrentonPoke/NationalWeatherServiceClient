package gov.noaa.stations.observations.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MinTemperatureLast24Hours{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("qualityControl")
	private Object qualityControl;

	@JsonProperty("value")
	private Float value;
}