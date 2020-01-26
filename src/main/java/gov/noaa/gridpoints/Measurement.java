package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
		public String toJson(boolean pretty){
			if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
		}
	}
}