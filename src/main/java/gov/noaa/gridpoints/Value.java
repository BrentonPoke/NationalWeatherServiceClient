package gov.noaa.gridpoints;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Value{

	@SerializedName("validTime")
	private String validTime;

	@SerializedName("value")
	private double value;
}