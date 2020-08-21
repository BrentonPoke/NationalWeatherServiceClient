
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class ZoneFeature extends Feature {
    
    private ZoneProperties properties;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
    
        return builder
            .serializeSpecialFloatingPointValues().create().toJson(this);
    }
}
