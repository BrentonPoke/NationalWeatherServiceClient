
package gov.noaa.models.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuppressWarnings("unused")
public class ZoneForecast {
    
    //TODO: Going to have to figure out how to deserialize empty objects the API returns.
    //@JsonDeserialize(using = EmptyToNullObject.class)
    //private FeatureCollection geometry;
    private List<Period> periods;
    private ZonedDateTime updated;
    
    public void setUpdated(String updated) {
        this.updated = ZonedDateTime.parse(updated);
    }
    
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
        
        return builder
            .serializeSpecialFloatingPointValues().serializeNulls().create().toJson(this);
    }
    
}
