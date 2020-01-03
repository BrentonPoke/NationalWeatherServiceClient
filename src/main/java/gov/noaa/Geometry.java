package gov.noaa;

import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Geometry {
  String type;
  ArrayList<Double> coordinates;
}
