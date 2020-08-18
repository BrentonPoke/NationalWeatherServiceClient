package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Targets{

	@JsonProperty("server")
	private Server server;

	@JsonProperty("radar")
	private Radar radar;

	@JsonProperty("ldm")
	private Ldm ldm;

	@JsonProperty("client")
	private Map<String,Boolean> client;

	@JsonProperty("misc")
	private Misc misc;
}