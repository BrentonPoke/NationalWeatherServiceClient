package gov.noaa.products;

import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductLocations {
  private Map<String, String> locations;
}