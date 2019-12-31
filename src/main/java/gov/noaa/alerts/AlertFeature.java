package gov.noaa.alerts;

import gov.noaa.Feature;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AlertFeature extends Feature {
private AlertProperties properties;
}
