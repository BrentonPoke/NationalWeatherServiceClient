package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Network{

	@JsonProperty("eth1")
	private Eth1 eth1;

	@JsonProperty("eth0")
	private Eth0 eth0;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
}