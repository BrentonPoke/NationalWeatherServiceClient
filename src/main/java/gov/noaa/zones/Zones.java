
package gov.noaa.zones;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Zones {

    private List<ZoneFeature> features;
    private String type;

}
