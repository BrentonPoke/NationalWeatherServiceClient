package gov.noaa.radar;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
class ServerCollection {
  @JsonProperty("@graph")
  private List<Server> servers;
}
