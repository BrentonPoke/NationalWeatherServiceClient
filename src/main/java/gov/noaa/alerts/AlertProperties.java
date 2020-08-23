
package gov.noaa.alerts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.Geocode;
import gov.noaa.Reference;
import gov.noaa.enums.Certainty;
import gov.noaa.enums.MessageType;
import gov.noaa.enums.Severity;
import gov.noaa.enums.Status;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertProperties {

    private List<String> affectedZones;
    private String areaDesc;
    private String category;
    private Certainty certainty;
    private String description;
    private ZonedDateTime effective;
    private ZonedDateTime ends;
    private String event;
    private ZonedDateTime expires;
    private Geocode geocode;
    private String headline;
    private String id;
    private String instruction;
    private MessageType messageType;
    private ZonedDateTime onset;
    private AlertParameters parameters;
    private List<Reference> references;
    private String response;
    private String sender;
    private String senderName;
    private ZonedDateTime sent;
    private Severity severity;
    private Status status;
    private String type;
    private String urgency;
    public void setSent(String sent){
        this.sent = ZonedDateTime.parse(sent);
    }
    public void setExpires(String expires){
        CharSequence text;
        this.expires = ZonedDateTime.parse(expires);
    }
    public void setEffective(String effective){
        this.effective = ZonedDateTime.parse(effective);
    }
    public void setEnds(String ends){
        this.ends = ZonedDateTime.parse(ends);
    }
    public void setOnset(String onset){
        this.onset = ZonedDateTime.parse(onset);
    }
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
