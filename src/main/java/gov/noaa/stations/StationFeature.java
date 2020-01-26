package gov.noaa.stations;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import lombok.Data;

@Data
public class StationFeature extends Feature {
	private StationProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}
