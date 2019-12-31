
package gov.noaa.alerts;

import gov.noaa.Parameters;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unused")
public class AlertParameters extends Parameters {

    private List<LocalDateTime> eventEndingTime;
    private List<String> NWSheadline;
    private List<String> VTEC;

}
