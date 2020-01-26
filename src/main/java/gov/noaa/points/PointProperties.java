package gov.noaa.points;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointProperties{

	@SerializedName("radarStation")
	private String radarStation;

	@SerializedName("fireWeatherZone")
	private String fireWeatherZone;

	@SerializedName("@type")
	private String type;

	@SerializedName("forecastZone")
	private String forecastZone;

	@SerializedName("county")
	private String county;

	@SerializedName("timeZone")
	private String timeZone;

	@SerializedName("forecast")
	private String forecast;

	@SerializedName("cwa")
	private String cwa;

	@SerializedName("relativeLocation")
	private RelativeLocation relativeLocation;

	@SerializedName("forecastHourly")
	private String forecastHourly;

	@SerializedName("observationStations")
	private String observationStations;

	@SerializedName("gridX")
	private Integer gridX;

	@SerializedName("forecastGridData")
	private String forecastGridData;

	@SerializedName("gridY")
	private Integer gridY;

	@SerializedName("forecastOffice")
	private String forecastOffice;

	@SerializedName("@id")
	private String id;

	@SerializedName("distance")
	private Distance distance;

	@SerializedName("city")
	private String city;

	@SerializedName("bearing")
	private Bearing bearing;

	@SerializedName("state")
	private String state;
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}