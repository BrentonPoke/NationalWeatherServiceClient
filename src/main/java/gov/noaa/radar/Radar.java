package gov.noaa.radar;

import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Radar{
	Map<String,Boolean> stations;
}