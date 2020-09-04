package gov.noaa;

import java.io.IOException;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@NoArgsConstructor
public class WeatherController<T,S> {
  private Class<S> clazz;
  Response<T> resp;
  WeatherServiceException exception = new WeatherServiceException();
 private final S service = WeatherServiceGenerator.createService(clazz);
  
  @SneakyThrows(value = IOException.class)
  public T call(Call<T> callSync){
    callSync.enqueue(new CallBack().invoke());
    return resp.body();
  }
  
  public S getService() {
return this.service;
  }
  @Log
  protected class CallBack {
    
    public Callback<T> invoke() {
      return new Callback<T>() {
        @Override
        public void onResponse(@NonNull Call<T> call, Response<T> response) {
          if (response.isSuccessful()) {
            resp = response;
          } else {
            exception = (WeatherServiceException) response.body();
          }
        }
    
        @Override
        public void onFailure(Call<T> call, Throwable t) {
      log.severe("Unable to make call: ".concat(t.getMessage()));
        }
      };
    }
  }
}
