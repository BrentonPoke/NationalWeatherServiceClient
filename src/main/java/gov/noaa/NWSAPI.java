package gov.noaa;

import gov.noaa.models.alerts.AlertService;
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
  
public Alerts getAllAlerts(Map<String, String> map){
  Call<Alerts> alerts = service.getAlerts(map);
  try {
    response = alerts.execute();
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
  Call<Alerts> zones = service.getZoneByID(zoneID);
  try {
    response = zones.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getZoneByID from {}",this.getClass(),e);
  }
  return response.body();
}

public Alerts getAlertByID(String id){
  Call<Alerts> alertsCall = service.getAlertByID(id);
  
  try {
    response = alertsCall.execute();
  } catch (IOException e) {
    log.error("Couldn't execute method getAlertsByID from {}",this.getClass(),e);
  }
  return response.body();
}

}