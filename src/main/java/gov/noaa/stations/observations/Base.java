
package gov.noaa.stations.observations;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Base {

    private String unitCode;
    private Long value;

}
