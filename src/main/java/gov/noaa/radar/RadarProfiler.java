package gov.noaa.radar;

import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class RadarProfiler {

    private String stationId;

    private Integer speed;

    private Double direction;

    private Double height;

    private ZonedDateTime timestamp;

    private Double averagingInterval;
    public void setTimestamp(String timestamp){
        this.timestamp = ZonedDateTime.parse(timestamp);
    }
}
