
package gov.noaa.zones;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.enums.State;
import gov.noaa.enums.ZoneType;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class ZoneProperties {

    private List<String> cwa;
    private List<String> forecastOffices;
    private String id;
    private String name;
    private State state;
    private List<String> timeZone;
    private ZoneType type;
    private String radarStation;
    private List<String> observationStations;
    private ZonedDateTime effectiveDate;
    private ZonedDateTime expirationDate;
    public void setState(String state){
        this.state = State.valueOfName(state);
    }
    
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = ZonedDateTime.parse(effectiveDate);
    }
    
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = ZonedDateTime.parse(expirationDate);
    }
    
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
