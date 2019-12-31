
package gov.noaa.stations.observations;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class CloudLayer {

    private String amount;
    private Base base;

}
