
package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class WeatherValue {

    private String validTime;
    private List<WeatherData> value;
    
    @Data
    class WeatherData {
        private String attributes;
        private String coverage;
        private String intensity;
        private String visibility;
        private String weather;
    }
    public String toJson(boolean pretty){
        if(pretty)
            return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
