package gov.noaa.stations;

import com.github.filosganga.geogson.model.Geometry;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Station{

	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private StationProperties properties;
}