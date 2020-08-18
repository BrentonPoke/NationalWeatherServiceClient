package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Command{

	@JsonProperty("lastExecutedTime")
	private ZonedDateTime lastExecutedTime;

	@JsonProperty("lastReceivedTime")
	private ZonedDateTime lastReceivedTime;
	
	@JsonProperty("lastNexradDataTime")
	private ZonedDateTime lastNexradDataTime;

	@JsonProperty("lastReceived")
	private String lastReceived;

	@JsonProperty("lastExecuted")
	private String lastExecuted;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
	public void setLastExecutedTime(String timestamp){
		this.lastExecutedTime = ZonedDateTime.parse(timestamp);
	}
	public void setLastReceivedTime(String timestamp) {
		this.lastReceivedTime = ZonedDateTime.parse(timestamp);
	}
	
	public void setLastNexradDataTime(String timestamp) {
		this.lastNexradDataTime = ZonedDateTime.parse(timestamp);
	}
}