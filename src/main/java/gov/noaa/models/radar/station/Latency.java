package gov.noaa.models.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

public class Latency{

	@JsonProperty("average")
	private Average average;

	@JsonProperty("current")
	private Current current;

	@JsonProperty("max")
	private Max max;

	@JsonProperty("host")
	private String host;

	@JsonProperty("maxLatencyTime")
	private ZonedDateTime maxLatencyTime;

	@JsonProperty("reportingHost")
	private String reportingHost;
	
	public void setMaxLatencyTime(String maxLatencyTime) {
		this.maxLatencyTime = ZonedDateTime.parse(maxLatencyTime);
	}
	
	public void setLevelTwoLastReceivedTime(String levelTwoLastReceivedTime) {
		this.levelTwoLastReceivedTime = ZonedDateTime.parse(levelTwoLastReceivedTime);
	}
	
	@JsonProperty("levelTwoLastReceivedTime")
	private ZonedDateTime levelTwoLastReceivedTime;
}