package gov.noaa.alerts;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface AlertService {
 @GET("/alerts")
  public Call<Alerts> getAlerts(@QueryMap Map<String,String> map);
 @GET("/alerts/active")
 public Call<Alerts> getActiveAlerts(@QueryMap Map<String,String> map);
 @GET("/alerts/{alertid}")
 public Call<Alerts> getAlertByID(@Path("alertid") String alertid);
 @GET("/alerts/types")
 public Call<AlertTypes> getAlertTypes();
}