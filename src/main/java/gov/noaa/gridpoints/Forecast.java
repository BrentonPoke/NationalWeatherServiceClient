package gov.noaa.gridpoints;

import com.github.filosganga.geogson.model.AbstractGeometry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Forecast{

	@SerializedName("geometry")
	private static AbstractGeometry geometry;

	@SerializedName("id")
	private String id;

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