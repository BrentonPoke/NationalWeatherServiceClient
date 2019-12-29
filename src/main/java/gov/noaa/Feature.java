
package gov.noaa;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Feature {

    private Geometry geometry;
    private String id;
    private Properties properties;
    private String type;

}
