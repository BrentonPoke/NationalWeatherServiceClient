
package gov.noaa;

import com.github.filosganga.geogson.model.Geometry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
public class Feature {

    protected static Geometry geometry;
    protected String id;
    protected String type;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
