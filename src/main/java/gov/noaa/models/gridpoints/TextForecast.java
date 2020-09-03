package gov.noaa.models.gridpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import gov.noaa.Feature;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextForecast extends Feature {

  private List<String> context;

  private GridpointsProperties properties;

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
