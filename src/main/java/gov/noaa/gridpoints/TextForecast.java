package gov.noaa.gridpoints;

import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geojson.GeometryCollection;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
          //.registerTypeAdapter(GeometryCollection.class, new InterfaceAdapter())
          .create()
          .toJson(this);
  }
}
