package gov.noaa;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Geometry {
  String type;
  ArrayList<Double> coordinates;
}
