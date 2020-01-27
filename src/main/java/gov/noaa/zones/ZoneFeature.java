
package gov.noaa.zones;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;

import com.github.filosganga.geogson.model.AbstractGeometry;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class ZoneFeature {

    private AbstractGeometry geometry;
    private String id;
    private ZoneProperties properties;
    private String type;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
    
        return builder.registerTypeAdapterFactory(new GeometryAdapterFactory())
            .serializeSpecialFloatingPointValues().create().toJson(this);
    }
}
