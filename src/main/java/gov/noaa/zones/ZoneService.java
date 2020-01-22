package gov.noaa.zones;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ZoneService {
  @GET("/zones")
  Call<Zones> getZones(@QueryMap Map<String, String> params);
}
