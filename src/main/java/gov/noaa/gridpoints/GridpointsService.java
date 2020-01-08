package gov.noaa.gridpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GridpointsService {
@GET("/gridpoints/{wfo}/{x},{y}")
  public Call<Forecast> getRawForecastData(@Path(value = "wfo")String weatherForecastStation, @Path(value = "x") Integer x, @Path(value = "y") Integer y);
}
