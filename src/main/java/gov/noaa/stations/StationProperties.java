package gov.noaa.stations;

import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class StationProperties {
	private Elevation elevation;
	private String stationIdentifier;
	private String type;
	private String name;
	private String timeZone;
	private String id;
	private String forecast;
	private String county;
	private String fireWeatherZone;
}
