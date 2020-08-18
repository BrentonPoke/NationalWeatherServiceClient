package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties{

	@JsonProperty("elevation")
	private Elevation elevation;

	@JsonProperty("stationType")
	private String stationType;

	@JsonProperty("latency")
	private Latency latency;

	@JsonProperty("name")
	private String name;

	@JsonProperty("timeZone")
	private String timeZone;

	@JsonProperty("id")
	private String id;

	@JsonProperty("rda")
	private RDA rda;

	@JsonProperty("superResolutionStatus")
	private String superResolutionStatus;

	@JsonProperty("mode")
	private String mode;

	@JsonProperty("controlStatus")
	private String controlStatus;

	@JsonProperty("generatorState")
	private String generatorState;

	@JsonProperty("alarmSummary")
	private String alarmSummary;

	@JsonProperty("resolutionVersion")
	private Integer resolutionVersion;

	@JsonProperty("operabilityStatus")
	private String operabilityStatus;

	@JsonProperty("volumeCoveragePattern")
	private String volumeCoveragePattern;

	@JsonProperty("averageTransmitterPower")
	private AverageTransmitterPower averageTransmitterPower;

	@JsonProperty("reflectivityCalibrationCorrection")
	private ReflectivityCalibrationCorrection reflectivityCalibrationCorrection;

	@JsonProperty("buildNumber")
	private Double buildNumber;

	@JsonProperty("status")
	private String status;
}