package gov.noaa.stations;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface StationService {
  @GET("/stations")
  public Call<Stations> getStations(@QueryMap Map<String,String> map);

}