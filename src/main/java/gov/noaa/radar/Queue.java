package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Queue {
  @JsonProperty("@graph")
  private List<RadarQueue> queues;

}
