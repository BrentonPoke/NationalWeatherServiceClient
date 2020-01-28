
package gov.noaa.zones;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Zones {

    private List<ZoneFeature> features;
    private String type;
public String toJson(boolean pretty){
    GsonBuilder builder = new GsonBuilder();
    if(pretty)
        builder.setPrettyPrinting();
    
            return builder.registerTypeAdapterFactory(new GeometryAdapterFactory())
            .serializeSpecialFloatingPointValues().create().toJson(this);
}
}