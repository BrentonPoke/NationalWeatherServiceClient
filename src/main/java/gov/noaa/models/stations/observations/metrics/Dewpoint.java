package gov.noaa.models.stations.observations.metrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dewpoint{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("qualityControl")
	private String qualityControl;

	@JsonProperty("value")
	private Float value;
}