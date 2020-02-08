package gov.noaa.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
		GsonBuilder gsonbuilder = new GsonBuilder();
		if(pretty)
			gsonbuilder.setPrettyPrinting();
        
            return gsonbuilder.serializeSpecialFloatingPointValues().create().toJson(this);
	}
}