package gov.noaa.gridpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	private String startTime;
	
	public LocalDateTime getStartTime(){
		return LocalDateTime.parse(this.startTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}

	private Boolean isDaytime;

	private String endTime;
	
	public LocalDateTime getEndTime(){
		return LocalDateTime.parse(this.startTime,DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}

	private String windDirection;

	private String windSpeed;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}