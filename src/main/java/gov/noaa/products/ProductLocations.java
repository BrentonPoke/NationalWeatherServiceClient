package gov.noaa.products;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductLocations {
  private Map<String, String> locations;
  public String toJson(boolean pretty){
    if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
  }
}