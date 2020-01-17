package gov.noaa.points;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Generated("com.robohorse.robopojogenerator")
public class Bearing{

	@SerializedName("unitCode")
	private String unitCode;

	@SerializedName("value")
	private Integer value;
}