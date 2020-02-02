package gov.noaa.offices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OfficeService {
  @GET("/offices/{officeid}")
  Call<Office> getOfficeByID(@Path("officeid") String officeID);
}
