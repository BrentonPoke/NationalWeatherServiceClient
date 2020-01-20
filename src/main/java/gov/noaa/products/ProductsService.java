package gov.noaa.products;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ProductsService {
  @GET("/products")
  Call<Products> getProducts(@QueryMap Map<String, String> parameters);

  @GET("/products/locations")
  Call<ProductLocations> getProductLocations();

  @GET("products/types")
  Call<ProductTypes> getProductTypes();

  @GET("/products/types/{typeId}")
  Call<Products> getProductsByID(@Path(value = "typeId") String typeid);

  @GET("products/types/{typeId}/locations")
  Call<ProductLocations> getProductLocationsForType(@Path(value = "typeId") String typeid);

  @GET("/products/types/{typeId}/locations/{locationId}")
  Call<Products> getProductsByTypeAndLocation(
      @Path(value = "typeId") String typeid, @Path(value = "locationId") String locationid);
}
