package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Measurement {


	private String uom;
	
	private List<Value> values;

	private String sourceUnit;
	
	@Data
	static class Value{
		
		private ZonedDateTime validTime;
		private Double value;
		public void setValidTime(String time){
			this.validTime = ZonedDateTime.parse(time);
		}
		public String toJson(boolean pretty){
			if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
		}
	}
}