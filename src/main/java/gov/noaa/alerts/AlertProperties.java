
package gov.noaa.alerts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.Geocode;
import gov.noaa.Reference;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class AlertProperties {

    private List<String> affectedZones;
    private String areaDesc;
    private String category;
    private String certainty;
    private String description;
    private String effective;
    private String ends;
    private String event;
    private String expires;
    private Geocode geocode;
    private String headline;
    private String id;
    private String instruction;
    private String messageType;
    private String onset;
    private AlertParameters parameters;
    private List<Reference> references;
    private String response;
    private String sender;
    private String senderName;
    private String sent;
    private String severity;
    private String status;
    private String type;
    private String urgency;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
