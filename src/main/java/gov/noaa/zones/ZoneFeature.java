
package gov.noaa.zones;

import com.github.filosganga.geogson.model.Geometry;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ZoneFeature {

    private static Geometry geometry;
    private String id;
    private ZoneProperties properties;
    private String type;

}
