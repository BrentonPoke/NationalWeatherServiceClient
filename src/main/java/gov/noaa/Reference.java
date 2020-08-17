
package gov.noaa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reference {

    private String id;
    private String identifier;
    private String sender;
    private ZonedDateTime sent;
    public void setSent(String sent){
        this.sent = ZonedDateTime.parse(sent);
    }
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
