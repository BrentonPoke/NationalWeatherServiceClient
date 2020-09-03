package gov.noaa.models.stations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.time.ZoneId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationProperties {
	private Elevation elevation;
	private String stationIdentifier;
	private String name;
	private ZoneId timeZone;
	private String forecast;
	private String county;
	private String fireWeatherZone;
	public void setTimeZone(String zone){
		this.timeZone = ZoneId.of(zone);
	}
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(this);
	}
}
