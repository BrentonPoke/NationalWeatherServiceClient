package gov.noaa.models.offices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OfficeService {
  @GET("/offices/{officeid}")
  Call<Office> getOfficeByID(@Path("officeid") String officeID);
  @GET("/offices/{officeid}/headlines")
  Call<OfficeHeadlines> getOfficeHeadlines(@Path("officeid")String officeID);
  @GET("/offices/{officeid}/headlines/{headlineid}")
  Call<Headline> getOfficeHeadlineBYID(@Path("officeid")String officeID, @Path("headlineid") String headlineID);
}
