package gov.noaa.stations.observations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.stations.Elevation;
import gov.noaa.stations.observations.metrics.BarometricPressure;
import gov.noaa.stations.observations.metrics.Dewpoint;
import gov.noaa.stations.observations.metrics.HeatIndex;
import gov.noaa.stations.observations.metrics.MaxTemperatureLast24Hours;
import gov.noaa.stations.observations.metrics.MinTemperatureLast24Hours;
import gov.noaa.stations.observations.metrics.PrecipitationLast3Hours;
import gov.noaa.stations.observations.metrics.RelativeHumidity;
import gov.noaa.stations.observations.metrics.SeaLevelPressure;
import gov.noaa.stations.observations.metrics.Temperature;
import gov.noaa.stations.observations.metrics.Visibility;
import gov.noaa.stations.observations.metrics.WindChill;
import gov.noaa.stations.observations.metrics.WindDirection;
import gov.noaa.stations.observations.metrics.WindGust;
import gov.noaa.stations.observations.metrics.WindSpeed;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationProperties {
	private String type;
	private String icon;
	private String rawMessage;
	private String station;
	private Temperature temperature;
	private Dewpoint dewpoint;
	private WindDirection windDirection;
	private WindSpeed windSpeed;
	private WindGust windGust;
	private BarometricPressure barometricPressure;
	private SeaLevelPressure seaLevelPressure;
	private Visibility visibility;
	private MaxTemperatureLast24Hours maxTemperatureLast24Hours;
	private MinTemperatureLast24Hours minTemperatureLast24Hours;
	private PrecipitationLast3Hours precipitationLast3Hours;
	private RelativeHumidity relativeHumidity;
	private WindChill windChill;
	private HeatIndex heatIndex;
	private String id;
	private ZonedDateTime timestamp;
	private Elevation elevation;
	private List<CloudLayer> cloudLayers;
	private String textDescription;
	private List<PresentWeather> present;
	public void setTimestamp(String timestamp){
		this.timestamp = ZonedDateTime.parse(timestamp);
	}
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}