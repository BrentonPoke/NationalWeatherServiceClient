package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Geometry;

@NoArgsConstructor
@Data
public class Forecast{

	private Geometry geometry;

	private String id;

	private String type;
	
	private List<String> context;

	private Properties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}