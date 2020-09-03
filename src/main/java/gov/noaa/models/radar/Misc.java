package gov.noaa.models.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Misc{

	@JsonProperty("backupIp")
	private Boolean backupIp;

	@JsonProperty("eth1")
	private Boolean eth1;

	@JsonProperty("eth0")
	private Boolean eth0;

	@JsonProperty("rocRouter")
	private Boolean rocRouter;

	@JsonProperty("tocRouter")
	private Boolean tocRouter;
}