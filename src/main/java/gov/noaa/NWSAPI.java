package gov.noaa;

import gov.noaa.models.alerts.AlertService;
import gov.noaa.models.alerts.Alerts;
import java.util.Map;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

@NoArgsConstructor
public class NWSAPI {
@SneakyThrows
public Alerts getAllAlerts(Map<String, String> map){
  AlertService service = WeatherServiceGenerator.createService(AlertService.class);
  Call<Alerts> alerts = service.getAlerts(map);
  Response<Alerts> response = alerts.execute();
    return response.body();
}
}