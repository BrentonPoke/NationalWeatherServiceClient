
package gov.noaa.models.offices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Address {

    private String addressLocality;
    private String addressRegion;
    private String postalCode;
    private String streetAddress;
    @JsonProperty("@type")
    private String type;

}
