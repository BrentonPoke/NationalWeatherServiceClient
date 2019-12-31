package gov.noaa.stations.observations;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Temperature{
	private String unitCode;
	private String qualityControl;
	private Double value;
}
