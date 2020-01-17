package gov.noaa.points;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Generated("com.robohorse.robopojogenerator")
public class Distance{

	@SerializedName("unitCode")
	private String unitCode;

	@SerializedName("value")
	private Double value;
}