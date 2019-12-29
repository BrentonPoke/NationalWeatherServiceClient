package gov.noaa.stations;
import gov.noaa.Feature;
import gov.noaa.Geometry;
import lombok.Data;

@Data
public class StationFeature extends Feature {
	private StationProperties properties;
}
