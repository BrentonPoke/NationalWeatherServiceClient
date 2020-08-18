package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Profiler {
  @JsonProperty("@graph")
  private List<RadarProfiler> profilers;
}
