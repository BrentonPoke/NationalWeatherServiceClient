package gov.noaa.gridpoints;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Measurement {

	@SerializedName("uom")
	private String uom;

	@SerializedName("values")
	private List<Value> values;

	@SerializedName("sourceUnit")
	private String sourceUnit;
	
	@Data
	class Value{
		
		@SerializedName("validTime")
		private String validTime;
		
		@SerializedName("value")
		private Double value;
	}
}