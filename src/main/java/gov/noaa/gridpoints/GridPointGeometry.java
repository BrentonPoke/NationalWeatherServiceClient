package gov.noaa.gridpoints;

import com.github.filosganga.geogson.model.Geometry;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GridPointGeometry{

	@SerializedName("geometries")
	private List<Geometry> geometries;

	@SerializedName("type")
	private String type;
}