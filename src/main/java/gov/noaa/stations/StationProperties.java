package gov.noaa.stations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}
