package gov.noaa.alerts;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface AlertService {
 @GET("/alerts")
  public Call<Alerts> getAlerts(@QueryMap Map<String,String> map);
}
