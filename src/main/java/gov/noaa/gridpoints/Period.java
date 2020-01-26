package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Period{

	@SerializedName("detailedForecast")
	private String detailedForecast;

	@SerializedName("temperatureTrend")
	private Object temperatureTrend;

	@SerializedName("shortForecast")
	private String shortForecast;

	@SerializedName("icon")
	private String icon;

	@SerializedName("number")
	private int number;

	@SerializedName("temperatureUnit")
	private String temperatureUnit;

	@SerializedName("name")
	private String name;

	@SerializedName("temperature")
	private int temperature;

	@SerializedName("startTime")
	private String startTime;

	@SerializedName("isDaytime")
	private boolean isDaytime;

	@SerializedName("endTime")
	private String endTime;

	@SerializedName("windDirection")
	private String windDirection;

	@SerializedName("windSpeed")
	private String windSpeed;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}