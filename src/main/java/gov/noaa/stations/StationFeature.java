package gov.noaa.stations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class StationFeature extends Feature {
	public void setGeometry(org.geojson.Point feature){
		geometry = feature;
	}
	private StationProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(this);
	}
}
