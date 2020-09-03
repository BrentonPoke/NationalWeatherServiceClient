package gov.noaa.models.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Ping{

	@JsonProperty("targets")
	private Targets targets;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
}