package gov.noaa.stations;

import java.util.List;
import lombok.Data;

@Data
public class Stations{
	private List<StationFeature> features;
	private String type;
	private List<String> context;
	private List<String> observationStations;
}