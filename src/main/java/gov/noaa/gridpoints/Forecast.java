package gov.noaa.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Polygon;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast{

	private Polygon geometry;

	private String id;

	private String type;
	
	private List<String> context;

	private Properties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}