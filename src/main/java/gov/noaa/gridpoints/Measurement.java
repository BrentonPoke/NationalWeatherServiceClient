package gov.noaa.gridpoints;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Measurement {

	@SerializedName("uom")
	private String uom;

	@SerializedName("values")
	private List<Value> values;

	@SerializedName("sourceUnit")
	private String sourceUnit;
}