
package gov.noaa.zones;

import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Period {

    private String detailedForecast;
    private String name;
    private Long number;
    public String toJson(boolean pretty){
        GsonBuilder builder = new GsonBuilder();
        if(pretty)
            builder.setPrettyPrinting();
        
        return builder
            .serializeSpecialFloatingPointValues().create().toJson(this);
    }
}
