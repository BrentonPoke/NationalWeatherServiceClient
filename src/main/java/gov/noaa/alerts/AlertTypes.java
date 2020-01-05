
package gov.noaa.alerts;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class AlertTypes {
    private List<String> eventTypes;

}
