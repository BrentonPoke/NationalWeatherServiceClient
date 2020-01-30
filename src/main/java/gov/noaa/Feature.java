
package gov.noaa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.Point;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    protected Point geometry;
    protected String id;
    protected String type;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
