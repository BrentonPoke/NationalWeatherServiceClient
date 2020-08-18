package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class RDA{

	@JsonProperty("reportingHost")
	private String reportingHost;

	@JsonProperty("properties")
	private Properties properties;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
}