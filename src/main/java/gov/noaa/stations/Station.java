package gov.noaa.stations;

import com.github.filosganga.geogson.model.Geometry;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Station{

	@SerializedName("geometry")
	private static Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private StationProperties properties;
}