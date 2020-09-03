package gov.noaa.models.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Hardware{

	@JsonProperty("disk")
	private Integer disk;

	@JsonProperty("memory")
	private Double memory;

	@JsonProperty("cpuIdle")
	private Double cpuIdle;

	@JsonProperty("ioUtilization")
	private Double ioUtilization;

	@JsonProperty("load5")
	private Double load5;

	@JsonProperty("load1")
	private Double load1;

	@JsonProperty("uptime")
	private ZonedDateTime uptime;

	@JsonProperty("load15")
	private Double load15;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;
	
	public void setUptime(String timestamp) {
		this.uptime = ZonedDateTime.parse(timestamp);
	}
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
}