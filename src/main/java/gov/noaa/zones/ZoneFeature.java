
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Geometry;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class ZoneFeature {

    private Geometry geometry;
    private String id;
    private ZoneProperties properties;
    private String type;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
    
        return builder
            .serializeSpecialFloatingPointValues().create().toJson(this);
    }
}
