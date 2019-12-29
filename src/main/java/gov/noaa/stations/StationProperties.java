package gov.noaa.stations;

import lombok.Data;

@Data
public class StationProperties {
	private Elevation elevation;
	private String stationIdentifier;
	private String type;
	private String name;
	private String timeZone;
	private String id;
}
