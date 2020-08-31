package gov.noaa;

import java.io.IOException;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class WeatherController<T,S> {
  Class<S> clazz;
  Call<T> callSync;
  Response<T> response;
  S service = WeatherServiceGenerator.createService(clazz);
  
  @SneakyThrows(value = IOException.class)
  public Response<T>  call(){
    return this.callSync.execute();
  }

  public S getService() {
return this.service;
  }
}
