package gov.noaa.models.enums;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeatureFlag {
  
  FORECAST_TEMPERATURE_QV("forecast_temperature_qv"),
  FORECAST_WIND_SPEED_QV("forecast_wind_speed_qv");
  @JsonValue
  private final String value;
}
