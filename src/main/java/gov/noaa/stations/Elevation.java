package gov.noaa.stations;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Elevation{
	private String unitCode;
	private Double value;
}
