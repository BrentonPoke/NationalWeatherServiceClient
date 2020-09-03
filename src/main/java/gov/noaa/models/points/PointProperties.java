package gov.noaa.models.points;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.ZoneId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointProperties{

	private String radarStation;

	private String fireWeatherZone;

	@JsonProperty("@type")
	private String type;

	private String forecastZone;

	private String county;

	private ZoneId timeZone;

	private String forecast;

	private String cwa;

	private RelativeLocation relativeLocation;

	private String forecastHourly;

	private String observationStations;

	private Integer gridX;

	private String forecastGridData;

	private Integer gridY;

	private String forecastOffice;

	@JsonProperty("@id")
	private String id;

	private Distance distance;

	private String city;

	private Bearing bearing;

	private String state;
	public void setTimeZone(String zone){
		this.timeZone = ZoneId.of(zone);
	}
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}