package gov.noaa.points;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Generated("com.robohorse.robopojogenerator")
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
}