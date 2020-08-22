package gov.noaa.stations;

import gov.noaa.stations.observations.Observation;
import gov.noaa.stations.observations.ObservationFeature;
import java.time.ZonedDateTime;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface StationService {
  @GET("/stations")
  Call<Stations> getStations(@QueryMap Map<String,String> map);
  @GET("/stations/{stationId}")
  Call<Station> getStation(@Path(value = "stationId") String stationId);
  @GET("/stations/{stationId}/observations")
  Call<ObservationFeature> getObservations(
      @Path("stationId")String stationId,
      @QueryMap Map<String,String> params);
  @GET("/stations/{stationId}/observations")
  Call<ObservationFeature> getObservations(
      @Path("stationId")String stationId);
  @GET("/stations/{stationId}/observations/{time}")
  Call<Observation> getObservationByTime(@Path("stationId")String stationId, @Path("time") ZonedDateTime time);
  
  
}