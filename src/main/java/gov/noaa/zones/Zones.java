
package gov.noaa.zones;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.model.AbstractGeometry;
import com.github.filosganga.geogson.model.MultiPolygon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.GeometryDeserializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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
