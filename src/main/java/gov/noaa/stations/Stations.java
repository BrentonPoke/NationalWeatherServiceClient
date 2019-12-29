package gov.noaa.stations;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stations{
	private List<StationFeature> features;
	private String type;
	private List<String> context;
	private List<String> observationStations;
}