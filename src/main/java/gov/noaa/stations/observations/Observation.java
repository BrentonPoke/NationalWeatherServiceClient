package gov.noaa.stations.observations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation extends Feature {
	private ObservationProperties properties;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}