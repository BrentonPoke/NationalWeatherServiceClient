
package gov.noaa.offices;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class OfficeHeadline {

    @JsonProperty("@graph")
    private List<Graph> graph;

}
