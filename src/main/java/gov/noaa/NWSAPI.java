package gov.noaa;

import gov.noaa.models.alerts.AlertService;
import gov.noaa.models.alerts.Alerts;
import java.util.Map;
import retrofit2.Call;

public class NWSAPI {
public Alerts getAllAlerts(Map<String, String> map){
  WeatherController<Alerts, AlertService> controller = new WeatherController<>();
  Call<Alerts> alerts = controller.getService().getAlerts(map);
  return controller.call(alerts);
}
}