package gov.noaa.stations;
import gov.noaa.Feature;
import lombok.Data;

@Data
public class StationFeature extends Feature {
	private StationProperties properties;
}
