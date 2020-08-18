package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class LDM{

	@JsonProperty("latestProduct")
	private String latestProduct;

	@JsonProperty("storageSize")
	private Long storageSize;

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("oldestProduct")
	private String oldestProduct;

	@JsonProperty("timestamp")
	private ZonedDateTime timestamp;

	@JsonProperty("rds")
	private Boolean rds;

	@JsonProperty("ldm4")
	private Boolean ldm4;

	@JsonProperty("ldm1")
	private Boolean ldm1;

	@JsonProperty("ldm2")
	private Boolean ldm2;
	private Boolean ldm3;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
}