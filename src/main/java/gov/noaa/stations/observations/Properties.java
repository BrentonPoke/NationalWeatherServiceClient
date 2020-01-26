package gov.noaa.stations.observations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.stations.Elevation;
import java.time.LocalDateTime;
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
	private LocalDateTime timestamp;
	private Elevation elevation;
	private List<CloudLayer> cloudLayers;
	private String textDescription;
	private List<PresentWeather> present;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}