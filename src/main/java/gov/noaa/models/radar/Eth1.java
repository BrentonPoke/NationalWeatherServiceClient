package gov.noaa.models.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Eth1{

	@JsonProperty("transDropped")
	private Integer transDropped;

	@JsonProperty("recvError")
	private Integer recvError;

	@JsonProperty("transNoError")
	private Integer transNoError;

	@JsonProperty("recvNoError")
	private Integer recvNoError;

	@JsonProperty("recvDropped")
	private Integer recvDropped;

	@JsonProperty("transOverrun")
	private Integer transOverrun;

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("interface")
	private String jsonMemberInterface;

	@JsonProperty("recvOverrun")
	private Integer recvOverrun;

	@JsonProperty("transError")
	private Integer transError;
}