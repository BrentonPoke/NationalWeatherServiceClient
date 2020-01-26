
package gov.noaa.alerts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Alerts {

    private List<String> context;
    private List<AlertFeature> features;
    private String title;
    private String type;
    private String updated;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
