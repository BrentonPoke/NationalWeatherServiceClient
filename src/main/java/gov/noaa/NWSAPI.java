package gov.noaa;

import gov.noaa.models.alerts.AlertService;
import gov.noaa.models.alerts.AlertTypes;
import gov.noaa.models.alerts.Alerts;
import java.io.IOException;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import retrofit2.Call;
import retrofit2.Response;

@NoArgsConstructor
@Log4j2
public class NWSAPI {
  
  private final AlertService service = WeatherServiceGenerator.createService(AlertService.class);
  private Response<Alerts> response;
  private Call<Alerts> alertsCall;
  
public Alerts getAllAlerts(Map<String, String> map){
  alertsCall = service.getAlerts(map);
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAllAlerts from {}",this.getClass(),e);
  }
  return response.body();
}

public Alerts getActiveAlerts(Map<String, String> map){
  map.put("active","true");
  return getAllAlerts(map);
}

public Alerts getZoneByID(String zoneID){
  alertsCall = service.getZoneByID(zoneID);
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getZoneByID from {}",this.getClass(),e);
  }
  return response.body();
}

public Alerts getAlertByID(String id){
  alertsCall = service.getAlertByID(id);
  
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAlertsByID from {}",this.getClass(),e);
  }
  return response.body();
}

public AlertTypes getAlertTypes(){
  Call<AlertTypes> types = service.getAlertTypes();
  Response<AlertTypes> response = null;
  try {
    response = types.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAlertTypes from {}",this.getClass(),e);
  }
  return response.body();
}

public Alerts getAlertsByMarineRegion(String region){
  alertsCall = service.getAlertsByMarineRegion(region);
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAlertsByMarineRegion from {}",this.getClass(),e);
  }
  return response.body();
}

public Alerts getAlertsByArea(String area){
  alertsCall = service.getAlertsByArea(area);
  
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAlertsByArea from {}",this.getClass(),e);
  }
  return response.body();
}

}