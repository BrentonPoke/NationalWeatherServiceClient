package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Period{

	private String detailedForecast;

	private Object temperatureTrend;

	private String shortForecast;

	private String icon;

	private Integer number;

	private String temperatureUnit;

	private String name;

	private Integer temperature;

	private String startTime;

	private Boolean isDaytime;

	private String endTime;

	private String windDirection;

	private String windSpeed;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}