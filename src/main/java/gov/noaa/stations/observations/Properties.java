package gov.noaa.stations.observations;

import gov.noaa.stations.Elevation;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Properties{
	private String type;
	private String icon;
	private String rawMessage;
	private String station;
	private Temperature temperature;
	private String id;
	private String timestamp;
	private Elevation elevation;
	private List<CloudLayer> cloudLayers;
	private String textDescription;
	private List<PresentWeatherItem> presentWeather;
}