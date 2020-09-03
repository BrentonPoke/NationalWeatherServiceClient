package gov.noaa.models.radar.station;

import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Alarm {

    private String stationId;

    private String status;

    private String message;

    private ZonedDateTime timestamp;
    public void setTimestamp(String timestamp){
        this.timestamp = ZonedDateTime.parse(timestamp);
    }
}
