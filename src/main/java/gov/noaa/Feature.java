
package gov.noaa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
public class Feature {

    private Geometry geometry;
    private String id;
    private String type;

}
