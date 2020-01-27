package gov.noaa.gridpoints;

import com.github.filosganga.geogson.model.GeometryCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GridPointGeometry{

	@SerializedName("geometries")
	private GeometryCollection geometries;

	@SerializedName("type")
	private String type;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}