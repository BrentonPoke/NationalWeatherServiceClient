package gov.noaa.radar.station;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class RadarStations{

	@JsonProperty("features")
	private List<RadarStationFeature> features;

	@JsonProperty("type")
	private String type;

}