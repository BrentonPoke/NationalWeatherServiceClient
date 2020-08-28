package gov.noaa.points;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointData extends Feature {

	private PointProperties properties;
	
	public void setGeometry(org.geojson.Point geometry) {
		super.setGeometry(geometry);
	}
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}