
package gov.noaa.offices;

import com.google.gson.GsonBuilder;
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
