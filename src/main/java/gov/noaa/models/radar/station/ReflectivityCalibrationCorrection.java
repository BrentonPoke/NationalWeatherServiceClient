package gov.noaa.models.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReflectivityCalibrationCorrection{

	@JsonProperty("unitCode")
	private String unitCode;

	@JsonProperty("value")
	private Double value;
}