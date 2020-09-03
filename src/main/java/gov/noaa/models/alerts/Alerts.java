
package gov.noaa.models.alerts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alerts {

    private List<String> context;
    private List<AlertFeature> features;
    private String title;
    private String type;
    private ZonedDateTime updated;
    public void setUpdated(String updated){
        this.updated = ZonedDateTime.parse(updated);
    }
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new GsonBuilder().create().toJson(this);
    }
}
