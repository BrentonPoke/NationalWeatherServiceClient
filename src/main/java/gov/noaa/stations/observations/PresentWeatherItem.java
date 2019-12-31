package gov.noaa.stations.observations;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PresentWeatherItem{
	private String intensity;
	private String rawString;
	private Object modifier;
	private String weather;
}
