package gov.noaa.stations.observations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.GsonBuilder;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationFeature {
  String type;
  List<Observation> features;
  public String toJson(boolean pretty){
    if(pretty)
      return new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create().toJson(this);
    else
      return new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(this);
  }
}
