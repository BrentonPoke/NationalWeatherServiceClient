
package gov.noaa.zones;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.model.Point;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ZoneForecast {
    private Geometry geometry ;
    private List<Period> periods;
    private String updated;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
        
        return builder.registerTypeAdapterFactory(new GeometryAdapterFactory())
            .serializeSpecialFloatingPointValues().serializeNulls().create().toJson(this);
    }
    @NoArgsConstructor
    @Data
    protected class Geometry{
        Point point;
    }
    
}
