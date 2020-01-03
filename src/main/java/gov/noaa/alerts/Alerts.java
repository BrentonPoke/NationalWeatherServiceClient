
package gov.noaa.alerts;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Alerts {

    private List<String> context;
    private List<AlertFeature> features;
    private String title;
    private String type;
    private String updated;

}
