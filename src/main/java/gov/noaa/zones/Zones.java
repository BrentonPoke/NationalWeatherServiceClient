
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuppressWarnings("unused")
public class Zones {

    private List<ZoneFeature> features;
    private String type;
public String toJson(boolean pretty){
    GsonBuilder builder = new GsonBuilder();
    if(pretty)
        builder.setPrettyPrinting();
    
            return builder
            .serializeSpecialFloatingPointValues().create().toJson(this);
}
}
