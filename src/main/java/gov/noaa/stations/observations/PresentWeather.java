package gov.noaa.stations.observations;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PresentWeather{
	private String intensity;
	private String rawString;
	private String modifier;
	private String weather;
}
