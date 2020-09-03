package gov.noaa.models.radar;

import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class RadarQueue {

    private String host;

    private ZonedDateTime arrivalTime;

    private ZonedDateTime creationTime;

    private String stationId;

    private String type;

    private String feed;

    private Double resolutionVersion;

    private String sequenceNumber;

    private Double size;
    public void setArrivalTime(String time){
        this.arrivalTime = ZonedDateTime.parse(time);
    }
    public void setCreationTime(String time){
        this.creationTime = ZonedDateTime.parse(time);
    }
}