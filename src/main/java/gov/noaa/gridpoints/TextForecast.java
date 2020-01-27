package gov.noaa.gridpoints;

import com.github.filosganga.geogson.model.GeometryCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TextForecast{

	@SerializedName("geometry")
	private static GeometryCollection geometry;

	@SerializedName("type")
	private String type;
	private List<String> context;

	@SerializedName("properties")
	private Properties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}