package gov.noaa;

import gov.noaa.models.alerts.AlertService;
import gov.noaa.models.alerts.AlertTypes;
import gov.noaa.models.alerts.Alerts;
import gov.noaa.models.glossary.Glossary;
import gov.noaa.models.glossary.GlossaryService;
import gov.noaa.models.gridpoints.Forecast;
import gov.noaa.models.gridpoints.GridpointsService;
import gov.noaa.models.gridpoints.TextForecast;
import gov.noaa.models.stations.Stations;
import java.io.IOException;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import retrofit2.Call;
import retrofit2.Response;

@NoArgsConstructor
@Log4j2
public class NWSAPI {

  static class AlertsAPI {
    private final AlertService service = WeatherServiceGenerator.createService(AlertService.class);
    private Response<Alerts> response;
    private Call<Alerts> alertsCall;

    public Alerts getAllAlerts(Map<String, String> map) {
      alertsCall = service.getAlerts(map);
      try {
        response = alertsCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getAllAlerts from {}", this.getClass(), e);
      }
      return response.body();
    }

    public Alerts getActiveAlerts(Map<String, String> map) {
      map.put("active", "true");
      return getAllAlerts(map);
    }

    public Alerts getZoneByID(String zoneID) {
      alertsCall = service.getZoneByID(zoneID);
      try {
        response = alertsCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getZoneByID from {}", this.getClass(), e);
      }
      return response.body();
    }

    public Alerts getAlertByID(String id) {
      alertsCall = service.getAlertByID(id);

      try {
        response = alertsCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getAlertsByID from {}", this.getClass(), e);
      }
      return response.body();
    }

    public AlertTypes getAlertTypes() {
      Call<AlertTypes> types = service.getAlertTypes();
      Response<AlertTypes> response = null;
      try {
        response = types.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getAlertTypes from {}", this.getClass(), e);
      }
      return response.body();
    }

    public Alerts getAlertsByMarineRegion(String region) {
      alertsCall = service.getAlertsByMarineRegion(region);
      try {
        response = alertsCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getAlertsByMarineRegion from {}", this.getClass(), e);
      }
      return response.body();
    }

    public Alerts getAlertsByArea(String area) {
      alertsCall = service.getAlertsByArea(area);
      try {
        response = alertsCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getAlertsByArea from {}", this.getClass(), e);
      }
      return response.body();
    }
}
  static class GlossaryAPI {
    private final GlossaryService service = WeatherServiceGenerator.createService(GlossaryService.class);
    Response<Glossary> response;
    public Glossary getGlossaryItems(){
    Call<Glossary> glossaryCall = service.getGlossaryItems();
    try{
    response = glossaryCall.execute();
    } catch (IOException e){
      log.error("Couldn't execute method getGlossaryItems from {}", this.getClass(), e);
    }
    return response.body();
    }
  }
  static class GridpointsAPI{
    Call<TextForecast> textForecastCall;
    Call<Stations> stationsCall;
    Call<Forecast> forecastCall;
    Response<Stations> stationsResponse;
    Response<Forecast> response;
    Response<TextForecast> textForecastResponse;
    private final GridpointsService service = WeatherServiceGenerator.createService(GridpointsService.class);
    Forecast getRawForecastData( String weatherForecastStation, Integer x, Integer y){
      forecastCall = service.getRawForecastData(weatherForecastStation,x,y);
      try {
        response = forecastCall.execute();
      } catch (IOException e) {
        log.error("Couldn't execute method getRawForecastData from {}", this.getClass(), e);
      }
      return response.body();
    }
    
    TextForecast getTextForecast(String forcastOffice, Integer x, Integer y, String unit){
      textForecastCall = service.getTextForecast(forcastOffice, x, y, unit);
      try{
        textForecastResponse = textForecastCall.execute();
      } catch (IOException e){
        log.error("Couldn't execute method getTextForecast from {}", this.getClass(), e);
      }
      return textForecastResponse.body();
    }
    TextForecast getHourlyTextForecast(String forcastOffice, Integer x, Integer y, String unit){
      textForecastCall = service.getHourlyTextForecast(forcastOffice, x, y, unit);
      try{
        textForecastResponse = textForecastCall.execute();
      } catch (IOException e){
        log.error("Couldn't execute method getHourlyTextForecast from {}", this.getClass(), e);
      }
      return textForecastResponse.body();
    }
    Stations getStationsByGridArea(String forcastOffice, Integer x, Integer y){
      stationsCall = service.getStationsByGridArea(forcastOffice, x, y);
      try{
        stationsResponse = stationsCall.execute();
      } catch (IOException e){
        log.error("Couldn't execute method getStationsByGridArea from {}", this.getClass(), e);
      }
      return stationsResponse.body();
    }
    
  }

}