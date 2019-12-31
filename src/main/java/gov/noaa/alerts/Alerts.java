
package gov.noaa.alerts;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Alerts {

    private List<String> context;
    private List<AlertFeature> features;
    private String title;
    private String type;
    private LocalDateTime updated;

}
