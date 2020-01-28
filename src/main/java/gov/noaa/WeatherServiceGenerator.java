package gov.noaa;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.model.Geometry;
import com.github.filosganga.geogson.model.GeometryCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherServiceGenerator {
  private static final String BASE_URL = "https://api.weather.gov";
  
  static Gson gson =
      new GsonBuilder()
          .registerTypeAdapterFactory(new GeometryAdapterFactory())
          .serializeSpecialFloatingPointValues().create();
  
  private static Retrofit.Builder builder
      = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson));

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
  
  public static class GeometryCollectionInstanceCreator implements InstanceCreator<GeometryCollection>{
  private List<Geometry<?>> geometry;
  
  public GeometryCollectionInstanceCreator(){
    this.geometry = new ArrayList<>();
  }
  
    @Override
    public GeometryCollection createInstance(Type type) {
      
      return GeometryCollection.of(this.geometry);
    }
  }

}
