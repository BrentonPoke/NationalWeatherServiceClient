
package gov.noaa.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class WeatherValue {

    private String validTime;
    private String value;
    private List<WeatherData> values;
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class WeatherData {
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
