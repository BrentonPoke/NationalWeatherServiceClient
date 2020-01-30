
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ZoneForecast {
    
    //TODO: Going to have to figure out how to deserialize empty objects the API returns.
    //@JsonDeserialize(using = EmptyToNullObject.class)
    //private FeatureCollection geometry;
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
