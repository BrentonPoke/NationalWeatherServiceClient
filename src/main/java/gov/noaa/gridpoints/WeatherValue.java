
package gov.noaa.gridpoints;

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
}
