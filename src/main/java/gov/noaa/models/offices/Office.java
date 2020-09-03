
package gov.noaa.models.offices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuppressWarnings("unused")
public class Office {

    private Address address;
    private List<String> approvedObservationStations;
    private String email;
    private String faxNumber;
    private String id;
    private String name;
    private String nwsRegion;
    private String parentOrganization;
    private List<String> responsibleCounties;
    private List<String> responsibleFireZones;
    private List<String> responsibleForecastZones;
    private String sameAs;
    private String telephone;
    @JsonProperty("@type")
    private String type;
    
    public String toJson(boolean pretty) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (pretty)
            gsonBuilder
                .setPrettyPrinting();
        return gsonBuilder
            .serializeSpecialFloatingPointValues()
            .create()
            .toJson(this);
    }

}
