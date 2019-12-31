package gov.noaa.stations.observations;

import gov.noaa.Geometry;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Observation{
	private Geometry geometry;
	private String id;
	private String type;
	private List<String> context;
	private Properties properties;

}