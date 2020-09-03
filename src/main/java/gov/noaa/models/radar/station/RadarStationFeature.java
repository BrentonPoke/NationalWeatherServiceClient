package gov.noaa.models.radar.station;

import gov.noaa.Feature;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class RadarStationFeature extends Feature {
   private Properties properties;
   public void setGeometry(org.geojson.Point feature){
       geometry = feature;
   }
}
