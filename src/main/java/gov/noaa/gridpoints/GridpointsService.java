package gov.noaa.gridpoints;

import gov.noaa.stations.Stations;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GridpointsService {
  @GET("/gridpoints/{wfo}/{x},{y}") // Returns raw numerical forecast data for a 2.5km grid area
  public Call<Forecast> getRawForecastData(
      @Path(value = "wfo") String weatherForecastStation,
      @Path(value = "x") Integer x,
      @Path(value = "y") Integer y);

  @GET("/gridpoints/{wfo}/{x},{y}/forecast") // Returns a textual forecast for a 2.5km grid area
  public Call<TextForecast> getTextForecast(
      @Path(value = "wfo") String weatherForecastStation,
      @Path(value = "x") Integer x,
      @Path("y") Integer y,
      @Query(value = "units") String unit);
  
  @GET("/gridpoints/{wfo}/{x},{y}/forecast/hourly") // Returns an hourly textual forecast for a 2.5km grid area
  public Call<TextForecast> getHourlyTextForecast(
      @Path(value = "wfo") String weatherForecastStation,
      @Path(value = "x") Integer x,
      @Path("y") Integer y,
      @Query(value = "units") String unit);
  
  @GET("/gridpoints/{wfo}/{x},{y}/stations") // Returns a textual forecast for a 2.5km grid area
  public Call<Stations> getStationsByGridArea(
      @Path(value = "wfo") String weatherForecastStation,
      @Path(value = "x") Integer x,
      @Path("y") Integer y);
}
