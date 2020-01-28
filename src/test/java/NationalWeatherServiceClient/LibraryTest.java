/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package NationalWeatherServiceClient;

import static org.junit.Assert.assertEquals;

import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.model.Coordinates;
import com.github.filosganga.geogson.model.Geometry;
import com.github.filosganga.geogson.model.GeometryCollection;
import com.github.filosganga.geogson.model.Point;
import com.github.filosganga.geogson.model.positions.SinglePosition;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import gov.noaa.WeatherServiceGenerator;
import gov.noaa.alerts.AlertService;
import gov.noaa.alerts.AlertTypes;
import gov.noaa.alerts.Alerts;
import gov.noaa.glossary.Glossary;
import gov.noaa.glossary.GlossaryService;
import gov.noaa.gridpoints.Forecast;
import gov.noaa.gridpoints.GridpointsService;
import gov.noaa.gridpoints.TextForecast;
import gov.noaa.points.PointData;
import gov.noaa.points.PointService;
import gov.noaa.products.ProductLocations;
import gov.noaa.products.ProductTypes;
import gov.noaa.products.Products;
import gov.noaa.products.ProductsService;
import gov.noaa.stations.Station;
import gov.noaa.stations.StationService;
import gov.noaa.stations.Stations;
import gov.noaa.zones.ZoneService;
import gov.noaa.zones.Zones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LibraryTest {
  
  private static class GeometryCollectionInstanceCreator implements InstanceCreator<GeometryCollection>{
    private List<Geometry<?>> geometry;
    
    public GeometryCollectionInstanceCreator(){
      this.geometry = new ArrayList<>();
    }
    
    @Override
    public GeometryCollection createInstance(Type type) {
      
      return GeometryCollection.of(this.geometry);
    }
  }

  static class TestWeatherServiceGenerator {
    private static final String BASE_URL =
        "https://37e6db5e-3ccd-4bbc-a1e4-835b4679eae4.mock.pstmn.io";
    static Gson gson =
        new GsonBuilder()
            .registerTypeAdapterFactory(new GeometryAdapterFactory())
            .serializeSpecialFloatingPointValues().create();
    private static Retrofit.Builder builder =
        new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
      return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final String token) {
      if (token != null) {
        httpClient.interceptors().clear();
        httpClient.addInterceptor(
            chain -> {
              Request original = chain.request();
              Request request = original.newBuilder().header("Authorization", token).build();
              return chain.proceed(request);
            });
        builder.client(httpClient.build());
        retrofit = builder.build();
      }
      return retrofit.create(serviceClass);
    }
  }

  @SneakyThrows
  @Test
  public void stationsTest() {
    FileInputStream input = new FileInputStream("src/test/resources/stations.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    Stations stations = gsonBuilder.create().fromJson(json.toString(), Stations.class);
    StationService service = WeatherServiceGenerator.createService(StationService.class);
    Call<Stations> callSync = service.getStations(ImmutableMap.of("state", "AZ", "limit", "2"));
    try {
      Response<Stations> response = callSync.execute();
      Stations stations1 = response.body();
      assertEquals(stations, stations1);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void glossaryTest() {
    FileInputStream input = new FileInputStream("src/test/resources/glossary.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    Glossary glossary = gsonBuilder.create().fromJson(json.toString(), Glossary.class);
    GlossaryService service = WeatherServiceGenerator.createService(GlossaryService.class);
    Call<Glossary> callSync = service.getGlossaryItems();
    try {
      Response<Glossary> response = callSync.execute();
      Glossary glossary1 = response.body();
      assertEquals(glossary, glossary1);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void alertTypeTest() {
    FileInputStream input = new FileInputStream("src/test/resources/AlertTypes.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    AlertTypes alertTypes = gsonBuilder.create().fromJson(json.toString(), AlertTypes.class);
    AlertService service = WeatherServiceGenerator.createService(AlertService.class);
    Call<AlertTypes> callSync = service.getAlertTypes();
    try {
      Response<AlertTypes> response = callSync.execute();
      assertEquals(alertTypes, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void alertsTest() {
    FileInputStream input = new FileInputStream("src/test/resources/alerts.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder()
            .put("active", "true")
            .put("area", "CA,CO,CT")
            .put("certainty", "likely")
            .put("status", "actual")
            .put("limit", "3")
            .build();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlerts(params);
    try {
      Response<Alerts> response = callSync.execute();

      assertEquals(alerts, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ActiveAlertsTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/alerts.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder()
            .put("area", "CA,CO,CT")
            .put("certainty", "likely")
            .put("status", "actual")
            .put("limit", "3")
            .build();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlerts(params);
    try {
      Response<Alerts> response = callSync.execute();
      Alerts alertsResponse = response.body();
      assertEquals(alerts, alertsResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void AlertByIDTest() {
    FileInputStream input = new FileInputStream("src/test/resources/IDAlert.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlertByID("NWS-IDP-PROD-3988177-3384711");
    try {
      Response<Alerts> response = callSync.execute();
      Alerts alertsResponse = response.body();
      assertEquals(alerts, alertsResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void getRegionByIDTest() {
    FileInputStream input = new FileInputStream("src/test/resources/getRegion.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlertsByMarineRegion("GL");
    try {
      Response<Alerts> response = callSync.execute();

      assertEquals(alerts, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void getAlertByAreaIDTest() {
    FileInputStream input = new FileInputStream("src/test/resources/getAlertsByArea.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlertsByArea("CO");
    try {
      Response<Alerts> response = callSync.execute();
      assertEquals(alerts, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void ZoneByIDTest() {
    FileInputStream input = new FileInputStream("src/test/resources/zonebyzoneid.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());
    System.out.println(json);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Alerts alerts = gsonBuilder.create().fromJson(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getZoneByID("AMZ158");
    try {
      Response<Alerts> response = callSync.execute();
      assertEquals(alerts, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void gridpointsForecastRawTest() {
    FileInputStream input = new FileInputStream("src/test/resources/gridpoints.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory());
    Forecast rawData = gsonBuilder.create().fromJson(json.toString(), Forecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<Forecast> callSync = service.getRawForecastData("TOP", 40, 60);
    try {
      Response<Forecast> response = callSync.execute();

      assertEquals(rawData, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void gridpointsTextForecastTest() {
    FileInputStream input = new FileInputStream("src/test/resources/gridpointsText.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory());
    TextForecast forecast = gsonBuilder.create().fromJson(json.toString(), TextForecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<TextForecast> callSync = service.getTextForecast("EAX", 50, 70, "si");
    try {
      Response<TextForecast> response = callSync.execute();

      assertEquals(forecast, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void gridpointsHourlyTextForecastTest() {
    FileInputStream input = new FileInputStream("src/test/resources/gridpointsHourlyText.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory())
            .enableComplexMapKeySerialization()
            .serializeSpecialFloatingPointValues();
    TextForecast forecast = gsonBuilder.create().fromJson(json.toString(), TextForecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<TextForecast> callSync = service.getTextForecast("TOP", 50, 70, "us");
    
    try {
      Response<TextForecast> response = callSync.execute();
      TextForecast textResponse = response.body();
      assertEquals(forecast, textResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void gridpointsStationsTest() {
    FileInputStream input = new FileInputStream("src/test/resources/gridpointsStations.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory());
    Stations forecast = gsonBuilder.create().fromJson(json.toString(), Stations.class);
    GridpointsService service = WeatherServiceGenerator.createService(GridpointsService.class);
    Call<Stations> callSync = service.getStationsByGridArea("TOP", 50, 70);
    try {
      Response<Stations> response = callSync.execute();

      assertEquals(forecast, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void StationTest() {
    FileInputStream input = new FileInputStream("src/test/resources/station.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory());
    Station forecast = gsonBuilder.create().fromJson(json.toString(), Station.class);
    StationService service = WeatherServiceGenerator.createService(StationService.class);
    Call<Station> callSync = service.getStation("KMYZ");
    try {
      Response<Station> response = callSync.execute();

      assertEquals(forecast, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @SneakyThrows
  @Test
  public void PointsTest() {
    FileInputStream input = new FileInputStream("src/test/resources/points.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GeometryAdapterFactory());
    PointData pointData = gsonBuilder.create().fromJson(json.toString(), PointData.class);
    PointService service = WeatherServiceGenerator.createService(PointService.class);
    SinglePosition position = new SinglePosition(Coordinates.of(-96.6306, 39.8553));
    Call<PointData> callSync = service.getPointData(new Point(position));
    try {
      Response<PointData> response = callSync.execute();

      assertEquals(pointData, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductsTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/products.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder()
            .put("type", "AFD,RRS")
            .put("location", "APX")
            .build();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Products products = gsonBuilder.create().fromJson(json.toString(), Products.class);
    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<Products> callSync = service.getProducts(params);
    try {
      Response<Products> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductLocationsTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/productLocations.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    ProductLocations products =
        gsonBuilder.create().fromJson(json.toString(), ProductLocations.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<ProductLocations> callSync = service.getProductLocations();
    try {
      Response<ProductLocations> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductTypesTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/productTypes.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    ProductTypes products = gsonBuilder.create().fromJson(json.toString(), ProductTypes.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<ProductTypes> callSync = service.getProductTypes();
    try {
      Response<ProductTypes> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductTypeByIDTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/productTypeByID.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    Products products = gsonBuilder.create().fromJson(json.toString(), Products.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<Products> callSync = service.getProductsByID("ADA");
    try {
      Response<Products> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductLocationsByTypeTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/productLocationsfortype.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    ProductLocations products =
        gsonBuilder.create().fromJson(json.toString(), ProductLocations.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<ProductLocations> callSync = service.getProductLocationsForType("ABV");
    try {
      Response<ProductLocations> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ProductsByTypeAndLocationTest() throws FileNotFoundException {
    FileInputStream input =
        new FileInputStream("src/test/resources/productsbytypeandlocation.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    GsonBuilder gsonBuilder = new GsonBuilder();
    Products products = gsonBuilder.create().fromJson(json.toString(), Products.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<Products> callSync = service.getProductsByTypeAndLocation("ABV", "APX");
    try {
      Response<Products> response = callSync.execute();

      assertEquals(products, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ZonesTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/zones.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder().put("area", "DE").put("type", "land").build();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Zones zones = gsonBuilder.create().fromJson(json.toString(), Zones.class);
    ZoneService service = WeatherServiceGenerator.createService(ZoneService.class);
    Call<Zones> callSync = service.getZones(params);
    try {
      Response<Zones> response = callSync.execute();
      assertEquals(zones, response.body());
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ZonesByTypeTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/zonesbytype.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder()
            .put("id", "ARZ001")
            .put("area", "AR")
            .put("include_geometry", "false")
            .build();

    GsonBuilder gsonBuilder =
        new GsonBuilder()
            .registerTypeAdapterFactory(new GeometryAdapterFactory())
            .serializeSpecialFloatingPointValues();
    Zones zones = gsonBuilder.create().fromJson(json.toString(), Zones.class);
    System.out.println(zones.toJson(false));
    ZoneService service = WeatherServiceGenerator.createService(ZoneService.class);
    Call<Zones> callSync = service.getZonesByType("land", params);
    try {
      Response<Zones> response = callSync.execute();
      Zones zoneResponse = response.body();
      
      System.out.println(response.body().toJson(false));
      
      assertEquals(zones, zoneResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }
}
