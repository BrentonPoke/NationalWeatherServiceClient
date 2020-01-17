package gov.noaa.points;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bearing{

	@SerializedName("unitCode")
	private String unitCode;

	@SerializedName("value")
	private Integer value;
}