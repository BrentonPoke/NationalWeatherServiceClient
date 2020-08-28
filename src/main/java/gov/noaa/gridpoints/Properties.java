package gov.noaa.gridpoints;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gov.noaa.stations.Elevation;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Properties{

	private Elevation elevation;

	private String validTimes;

	private String gridX;

	private String gridY;

	@JsonProperty("@type")
	private String type;

	private String forecastOffice;

	private ZonedDateTime updateTime;
	private ZonedDateTime updated;
	private String units;
	private String forecastGenerator;
	private String generatedAt;

	@JsonProperty("@id")
	private String id;

	private String gridId;
	
	private List<Period> periods;

	private Measurement apparentTemperature;
	private Measurement atmosphericDispersionIndex;
	private Measurement ceilingHeight;
	private Measurement davisStabilityIndex;
	private Measurement dewpoint;
	private Measurement dispersionIndex;
	private Measurement grasslandFireDangerIndex;
	private Measurement hainesIndex;
	private Measurement hazards;
	private Measurement heatIndex;
	private Measurement iceAccumulation;
	private Measurement lightningActivityLevel;
	private Measurement lowVisibilityOccurrenceRiskIndex;
	private Measurement maxTemperature;
	private Measurement minTemperature;
	private Measurement mixingHeight;
	private Measurement potentialOf15mphWinds;
	private Measurement potentialOf20mphWindGusts;
	private Measurement potentialOf25mphWinds;
	private Measurement potentialOf30mphWindGusts;
	private Measurement potentialOf35mphWinds;
	private Measurement potentialOf40mphWindGusts;
	private Measurement potentialOf45mphWinds;
	private Measurement potentialOf50mphWindGusts;
	private Measurement potentialOf60mphWindGusts;
	private Measurement pressure;
	private Measurement primarySwellDirection;
	private Measurement primarySwellHeight;
	private Measurement probabilityOfHurricaneWinds;
	private Measurement probabilityOfPrecipitation;
	private Measurement probabilityOfThunder;
	private Measurement probabilityOfTropicalStormWinds;
	private Measurement quantitativePrecipitation;
	private Measurement redFlagThreatIndex;
	private Measurement relativeHumidity;
	private Measurement secondarySwellDirection;
	private Measurement secondarySwellHeight;
	private Measurement skyCover;
	private Measurement snowLevel;
	private Measurement snowfallAmount;
	private Measurement stability;
	private Measurement temperature;
	private Measurement transportWindDirection;
	private Measurement transportWindSpeed;
	private Measurement twentyFootWindDirection;
	private Measurement twentyFootWindSpeed;
	private Measurement visibility;
	private Measurement waveDirection;
	private Measurement waveHeight;
	private Measurement wavePeriod;
	private Measurement wavePeriod2;
	private WeatherValue weather;
	private Measurement windChill;
	private Measurement windDirection;
	private Measurement windGust;
	private Measurement windSpeed;
	private Measurement windWaveHeight;
	public void setUpdated(String time){this.updated = ZonedDateTime.parse(time);}
	public void setUpdateTime(String time){this.updateTime = ZonedDateTime.parse(time);}
	public String toJson(boolean pretty){
		if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
	}
}