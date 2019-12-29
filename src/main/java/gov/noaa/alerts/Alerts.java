
package gov.noaa.alerts;

import gov.noaa.Feature;
import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Alerts {

    private List<String> context;
    private List<Feature> features;
    private String title;
    private String type;
    private String updated;

}
