package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Server{

	@JsonProperty("collectionTime")
	private ZonedDateTime collectionTime;

	@JsonProperty("ping")
	private Ping ping;

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("type")
	private String type;

	@JsonProperty("radarNetworkUp")
	private Boolean radarNetworkUp;

	@JsonProperty("command")
	private Command command;

	@JsonProperty("aggregate")
	private Boolean aggregate;

	@JsonProperty("network")
	private Network network;

	@JsonProperty("ldm")
	private LDM ldm;

	@JsonProperty("id")
	private String id;

	@JsonProperty("locked")
	private Boolean locked;

	@JsonProperty("reportingHost")
	private String reportingHost;

	@JsonProperty("primary")
	private Boolean primary;

	@JsonProperty("hardware")
	private Hardware hardware;

	@JsonProperty("rds")
	private Boolean rds;

	@JsonProperty("ldm4")
	private Boolean ldm4;

	@JsonProperty("ldm1")
	private Boolean ldm1;

	@JsonProperty("ldm2")
	private Boolean ldm2;
	public void setCollectionTime(String timestamp){
		this.collectionTime = ZonedDateTime.parse(timestamp);
	}
}