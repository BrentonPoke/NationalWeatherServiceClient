package gov.noaa;

import java.io.IOException;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

@NoArgsConstructor
public class WeatherController<T,S> {
  private Class<S> clazz;
    Response<T> response;
 private final S service = WeatherServiceGenerator.createService(clazz);
  
  @SneakyThrows(value = IOException.class)
  public T call(Call<T> callSync){
    response = callSync.execute();
    return response.body();
  }

  public S getService() {
return this.service;
  }
}
