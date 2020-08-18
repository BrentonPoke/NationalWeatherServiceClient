package gov.noaa.points;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.geojson.Point;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointData{

	private Point geometry;

	private String id;

	private String type;

	private PointProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}