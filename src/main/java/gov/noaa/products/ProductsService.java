package gov.noaa.products;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProductsService {
  @GET("/products")
  Call<Products> getProducts(@QueryMap Map<String, String> parameters);
  @GET("/products/locations")
  Call<ProductLocations> getProductLocations();
}
