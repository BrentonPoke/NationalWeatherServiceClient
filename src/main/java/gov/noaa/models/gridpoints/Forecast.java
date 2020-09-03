package gov.noaa.models.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import gov.noaa.Feature;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast extends Feature {
	
	private List<String> context;

	private GridpointsProperties properties;
	
	public void setGeometry(org.geojson.Polygon geometry) {
		this.geometry = geometry;
	}

	public String toJson(boolean pretty){
		GsonBuilder gsonbuilder = new GsonBuilder();
		if(pretty)
			gsonbuilder.setPrettyPrinting();
        
            return gsonbuilder.serializeSpecialFloatingPointValues().create().toJson(this);
	}
}