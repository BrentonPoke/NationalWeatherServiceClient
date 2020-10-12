package gov.noaa;

import gov.noaa.models.alerts.AlertService;
import gov.noaa.models.alerts.Alerts;
import java.io.IOException;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

@NoArgsConstructor
public class NWSAPI {
  
  private Logger logger = LoggerFactory.getLogger(NWSAPI.class);
  private final AlertService service = WeatherServiceGenerator.createService(AlertService.class);
  private Response<Alerts> response;
  
@SneakyThrows
public Alerts getAllAlerts(Map<String, String> map){
  Call<Alerts> alerts = service.getAlerts(map);
  response = alerts.execute();
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
    logger.error("Couldn't execute method getZoneByID from {}",this.getClass(),e);
  }
  return response.body();
}
}