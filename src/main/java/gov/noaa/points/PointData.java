package gov.noaa.points;

import com.github.filosganga.geogson.model.Geometry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointData{

	@SerializedName("geometry")
	private static Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private PointProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}