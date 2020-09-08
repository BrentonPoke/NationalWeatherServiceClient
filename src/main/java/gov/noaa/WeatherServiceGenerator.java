package gov.noaa;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class WeatherServiceGenerator<T> {
  static {
    if(System.getenv().containsKey("MOCK_WEATHER_URL"))
      BASE_URL = System.getenv("MOCK_WEATHER_URL");
    else BASE_URL  = "https://api.weather.gov";
  }
  private static final String BASE_URL; //= "https://api.weather.gov";
  Response<T> resp;
  WeatherServiceException exception = new WeatherServiceException();
  
  static ObjectMapper mapper = new ObjectMapper();
  
  private static Retrofit.Builder builder
      = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(JacksonConverterFactory.create(mapper));

  private static Retrofit retrofit = builder.build();

  private static OkHttpClient.Builder httpClient
      = new OkHttpClient.Builder();

  public static <S> S createService(Class<S> serviceClass) {
    return retrofit.create(serviceClass);
  }
  public static <S> S createService(Class<S> serviceClass, final String token ) {
    if ( token != null ) {
      httpClient.interceptors().clear();
      httpClient.addInterceptor( chain -> {
        Request original = chain.request();
        Request request = original.newBuilder()
            .header("Authorization", token)
            .build();
        return chain.proceed(request);
      });
      builder.client(httpClient.build());
      retrofit = builder.build();
    }
    return retrofit.create(serviceClass);
  }

}
