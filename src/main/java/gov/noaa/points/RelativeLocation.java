package gov.noaa.points;

import com.github.filosganga.geogson.model.Geometry;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelativeLocation{

	@SerializedName("geometry")
	private static Geometry geometry;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private PointProperties properties;
}