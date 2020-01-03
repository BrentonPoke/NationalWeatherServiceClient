
package gov.noaa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
public class Feature {

    protected Geometry geometry;
    protected String id;
    protected String type;

}
