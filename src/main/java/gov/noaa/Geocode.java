
package gov.noaa;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Geocode {

    private List<String> SAME;
    private List<String> UGC;

}
