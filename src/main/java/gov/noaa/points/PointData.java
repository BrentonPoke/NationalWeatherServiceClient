package gov.noaa.points;

import com.github.filosganga.geogson.model.Geometry;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Generated("com.robohorse.robopojogenerator")
public class PointData{

	@SerializedName("geometry")
	private static Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private PointProperties properties;
}