package gov.noaa.alerts;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface AlertService {
  @GET("/alerts")
  Call<Alerts> getAlerts(@QueryMap Map<String, String> map);

  @GET("/alerts/active")
  Call<Alerts> getActiveAlerts(@QueryMap Map<String, String> map);

  @GET("/alerts/active/zone/{zoneid}")
  Call<Alerts> getZoneByID(@Path(value = "zoneid") String zoneid);

  @GET("/alerts/{alertid}")
  Call<Alerts> getAlertByID(@Path("alertid") String alertid);

  @GET("/alerts/types")
  Call<AlertTypes> getAlertTypes();

  @GET("/alerts/active/region/{region}")
  Call<Alerts> getAlertsByMarineRegion(@Path(value = "region") String region);

  @GET("/alerts/active/area/{area}")
  Call<Alerts> getAlertsByArea(@Path(value = "area") String area);
}