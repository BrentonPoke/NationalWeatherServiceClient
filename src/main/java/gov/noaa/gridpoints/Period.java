package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Period{

	private String detailedForecast;

	private String temperatureTrend;

	private String shortForecast;

	private String icon;

	private Integer number;

	private String temperatureUnit;

	private String name;

	private Integer temperature;

	private ZonedDateTime startTime;

	private Boolean isDaytime;

	private ZonedDateTime endTime;
	public void setStartTime(String time){this.startTime = ZonedDateTime.parse(time);}
	public void setEndTime(String time){this.endTime = ZonedDateTime.parse(time);}

	private String windDirection;

	private String windSpeed;
	
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}