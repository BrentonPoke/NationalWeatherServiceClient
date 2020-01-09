package gov.noaa.gridpoints;

import com.github.filosganga.geogson.model.Geometry;
import gov.noaa.Context;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TextForecast{

	@SerializedName("geometry")
	private static Geometry geometry;

	@SerializedName("type")
	private String type;
	private List<String> context;

	@SerializedName("properties")
	private Properties properties;
}