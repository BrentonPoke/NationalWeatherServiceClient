
package gov.noaa.alerts;

import com.google.gson.annotations.SerializedName;
import gov.noaa.Parameters;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unused")
public class AlertParameters extends Parameters {

    private List<String> eventEndingTime;
    private List<String> NWSheadline;
    private List<String> VTEC;
    private List<String> HazardType;
    @SerializedName(value = "EASORG",alternate = "EAS-ORG")
    private List<String> EASORG;

}
