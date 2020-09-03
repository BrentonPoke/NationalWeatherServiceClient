package gov.noaa.models.stations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Elevation{
	private String unitCode;
	private Float value;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(this);
	}
}
