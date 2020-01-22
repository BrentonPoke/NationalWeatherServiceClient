
package gov.noaa.zones;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ZoneProperties {

    private List<String> cwa;
    private List<String> forecastOffices;
    private String id;
    private String name;
    private String state;
    private List<String> timeZone;
    private String type;

}
