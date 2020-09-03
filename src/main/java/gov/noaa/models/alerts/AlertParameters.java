
package gov.noaa.models.alerts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fasterxml.jackson.annotation.JsonAlias;
import gov.noaa.Parameters;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unused")
public class AlertParameters extends Parameters {

    private List<String> eventEndingTime;
    private List<String> NWSheadline;
    private List<String> VTEC;
    private List<String> HazardType;
    @JsonAlias({"EASORG","EAS-ORG"})
    private List<String> EASORG;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
