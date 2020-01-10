package gov.noaa.stations;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StationProperties {
	private Elevation elevation;
	private String stationIdentifier;
	private String name;
	private String timeZone;
	private String forecast;
	private String county;
	private String fireWeatherZone;
}
