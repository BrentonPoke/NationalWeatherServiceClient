package gov.noaa.stations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Point;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station{

	private Point geometry;

	private String id;

	private String type;

	@SerializedName("properties")
	private StationProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}