
package gov.noaa.models.offices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class OfficeHeadlines {

    @JsonProperty("@graph")
    private List<Headline> headlines;
    public String toJson(boolean pretty) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (pretty)
            gsonBuilder
                .setPrettyPrinting();
        return gsonBuilder
            .serializeSpecialFloatingPointValues().disableHtmlEscaping()
            .create()
            .toJson(this);
    }
}
