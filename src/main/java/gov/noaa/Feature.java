
package gov.noaa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.geojson.GeoJsonObject;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    protected GeoJsonObject geometry;
    protected String id;
    protected String type;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
