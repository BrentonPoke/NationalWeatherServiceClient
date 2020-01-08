
package gov.noaa;

import com.github.filosganga.geogson.model.Geometry;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@NoArgsConstructor
public class Feature {

    protected static Geometry geometry;
    protected String id;
    protected String type;

}
