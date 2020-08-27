
package gov.noaa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class WeatherServiceException extends IOException {

    private String correlationId;
    private String detail;
    private String instance;
    private Integer status;
    private String title;
    private String type;
    public String toJson(boolean pretty){
            if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
