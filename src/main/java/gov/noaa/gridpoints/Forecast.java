package gov.noaa.gridpoints;




import com.github.filosganga.geogson.model.Geometry;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Forecast{

	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;
	private List<String> context;

	@SerializedName("properties")
	private Properties properties;
}