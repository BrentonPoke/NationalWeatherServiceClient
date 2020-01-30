
package gov.noaa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameters {
    @JsonProperty("BLOCKCHANNEL")
    protected List<String> BLOCKCHANNEL;
    @JsonProperty("PIL")
    protected List<String> PIL;
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
