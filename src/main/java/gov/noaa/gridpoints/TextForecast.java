package gov.noaa.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.GeometryCollection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextForecast {

  private GeometryCollection geometry;

  private String type;

  private List<String> context;

  private Properties properties;

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
