
package gov.noaa;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Properties {

    private List<String> affectedZones;
    private String areaDesc;
    private String category;
    private String certainty;
    private String description;
    private LocalDateTime effective;
    private LocalDateTime ends;
    private String event;
    private LocalDateTime expires;
    private Geocode geocode;
    private String headline;
    private String id;
    private String instruction;
    private String messageType;
    private LocalDateTime onset;
    private Parameters parameters;
    private List<Reference> references;
    private String response;
    private String sender;
    private String senderName;
    private String sent;
    private String severity;
    private String status;
    private String type;
    private String urgency;

}
