package gov.noaa.zones;

import gov.noaa.stations.StationFeature;
import gov.noaa.stations.Stations;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
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
  @GET("/zones/{type}/{zoneId}")
  Call<ZoneForecast> getZoneByID(@Path(value = "type") String type,@Path(value = "zoneId") String zoneId);
  @GET("/zones/forecast/{zoneId}/stations")
  Call<Stations> getObservationStationMetadataByZone(@Path(value = "zoneId") String zoneId);
  default List<StationFeature> getObservationStationsByZone(String zoneId) {
    try {
      return this.getObservationStationMetadataByZone(zoneId).execute().body().getFeatures();
    } catch (IOException e) {
      Logger.getLogger("ZoneService").severe("This method calls getObservationStationMetadataByZone(), and that method failed: "+e.getMessage());
    }
    return null;
  }
}
