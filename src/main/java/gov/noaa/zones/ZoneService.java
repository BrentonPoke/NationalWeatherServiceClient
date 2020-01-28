package gov.noaa.zones;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ZoneService {
  @GET("/zones")
  Call<Zones> getZones(@QueryMap Map<String, String> params);
  @GET("/zones/{type}")
  Call<Zones> getZonesByType(@Path(value = "type") String type, @QueryMap Map<String, String> params);
  @GET("/zones/{type}/{zoneId}/forecast")
  Call<ZoneForecast> getZoneForecastByID(@Path(value = "type") String type,@Path(value = "zoneId") String zoneId);
}