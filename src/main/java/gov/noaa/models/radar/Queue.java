package gov.noaa.models.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
class Queue {
  @JsonProperty("@graph")
  private List<RadarQueue> queues;

}
