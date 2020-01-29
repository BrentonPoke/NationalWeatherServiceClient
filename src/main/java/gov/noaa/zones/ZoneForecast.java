
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Geometry;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ZoneForecast {
    private Geometry geometry;
    private List<Period> periods;
    private String updated;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
        
        return builder
            .serializeSpecialFloatingPointValues().serializeNulls().create().toJson(this);
    }
    
}
