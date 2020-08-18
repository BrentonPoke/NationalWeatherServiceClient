package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Stations{

	@JsonProperty("features")
	private List<RadarStationFeature> features;

	@JsonProperty("type")
	private String type;

}