
package gov.noaa.offices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class Headline {

    private String content;
    private String id;
    private Boolean important;
    private String issuanceTime;
    private String link;
    private String name;
    private String office;
    private String summary;
    private String title;
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
