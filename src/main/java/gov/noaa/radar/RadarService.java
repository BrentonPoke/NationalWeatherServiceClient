package gov.noaa.radar;

import gov.noaa.radar.station.Alarm;
import gov.noaa.radar.station.RadarStationFeature;
import gov.noaa.radar.station.RadarStations;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RadarService {
  @GET("/radar/servers")
  Call<ServerCollection> getRadarServers(@Query(value = "reportingHost") String rHost);
  @GET("/radar/servers")
  Call<ServerCollection> getRadarServers();
  default List<Server> getServers(String rHost) throws IOException {
    return getRadarServers(rHost).execute().body().getServers();
  }
  @GET("/radar/servers/{id}")
  Call<Server> getServer(@Path(value = "id")String id, @Query(value = "reportingHost") String rHost);
  @GET("/radar/servers/{id}")
  Call<Server> getServer(@Path(value = "id")String id);
  @GET("/radar/stations")
  Call<RadarStations> getRadarStations(
      @QueryMap Map<String,String> stationTypes,
      @Query(value = "reportingHost") String rHost,
      @Query(value= "host")String host);
  @GET("/radar/stations/{stationId}")
  Call<RadarStationFeature> getRadarStationMetaData(
      @Path(value = "stationId") String stationId,
      @Query(value = "reportingHost") String rHost,
      @Query(value= "host")String host);
  @GET("/radar/stations/{stationId}")
  Call<RadarStationFeature> getRadarStationMetadata(@Path(value = "stationId") String stationId);
  @GET("/radar/stations/{stationId}/alarms")
  Call<List<Alarm>> getAlarms(@Path(value = "stationId")String stationId);
  @GET("/radar/queues/{host}")
  Call<Queue> getRadarQueueMetadata(@Path(value = "host")String host,
      @Query(value = "limit")Integer limit,
      @Query(value = "arrived")String arrived,
      @Query(value = "created")String created,
      @Query(value = "published") String published,
      @Query(value = "station")String station,
      @Query(value = "type")String type,
      @Query(value = "feed")String feed,
      @Query(value = "resolution")Integer resolution);
  @GET("/radar/queues/{host}")
  Call<Queue> getRadarQueueMetadata(@Path(value = "host")String host);
  default List<RadarQueue> getRadarQueues(String host) throws IOException {
    return getRadarQueueMetadata(host).execute().body().getQueues();
  }
  @GET("/radar/profilers/{stationId}")
  Call<ProfilerCollection> getRadarProfilerMetadata(
      @Path("stationId")String stationId,
      @Query("time")String time,
      @Query("interval")String interval);
  default List<RadarProfiler> getRadarProfilers(String stationId, String time, String interval)
      throws IOException {
    return getRadarProfilerMetadata(stationId, time, interval).execute().body().getProfilers();
  }
  
}
