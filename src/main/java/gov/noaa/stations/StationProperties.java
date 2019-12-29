package gov.noaa.stations;

import java.util.TimeZone;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StationProperties {
	private Elevation elevation;
	private String stationIdentifier;
	private String type;
	private String name;
	private TimeZone timeZone;
	private String id;
	private String forecast;
	private String county;
	private String fireWeatherZone;
}
