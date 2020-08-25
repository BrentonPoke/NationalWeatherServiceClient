/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package NationalWeatherServiceClient;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import gov.noaa.WeatherServiceGenerator;
import gov.noaa.alerts.AlertService;
import gov.noaa.alerts.AlertTypes;
import gov.noaa.alerts.Alerts;
import gov.noaa.enums.State;
import gov.noaa.glossary.Glossary;
import gov.noaa.glossary.GlossaryService;
import gov.noaa.gridpoints.Forecast;
import gov.noaa.gridpoints.GridpointsService;
import gov.noaa.gridpoints.TextForecast;
import gov.noaa.offices.Headline;
import gov.noaa.offices.Office;
import gov.noaa.offices.OfficeHeadlines;
import gov.noaa.offices.OfficeService;
import gov.noaa.points.PointData;
import gov.noaa.points.PointService;
import gov.noaa.products.ProductLocations;
import gov.noaa.products.ProductTypes;
import gov.noaa.products.Products;
import gov.noaa.products.ProductsService;
import gov.noaa.stations.StationFeature;
import gov.noaa.stations.StationService;
import gov.noaa.stations.Stations;
import gov.noaa.stations.observations.ObservationFeature;
import gov.noaa.zones.ZoneForecast;
import gov.noaa.zones.ZoneService;
import gov.noaa.zones.Zones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LibraryTest {

  static class TestWeatherServiceGenerator {
    private static final String BASE_URL =
        "https://37e6db5e-3ccd-4bbc-a1e4-835b4679eae4.mock.pstmn.io";
    static ObjectMapper mapper = new ObjectMapper();
    private static Retrofit.Builder builder =
        new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(mapper));

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
  // @Test
  public void stationsTest() {
    FileInputStream input = new FileInputStream("src/test/resources/stations.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();
    Stations stations = mapper.readValue(json.toString(), Stations.class);
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

    ObjectMapper mapper = new ObjectMapper();
    Glossary glossary = mapper.readValue(json.toString(), Glossary.class);
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

    ObjectMapper mapper = new ObjectMapper();
    AlertTypes alertTypes = mapper.readValue(json.toString(), AlertTypes.class);
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
    //TODO convert this to a Utils method for an upcoming iteration of the API
    ArrayList<String> area = new ArrayList<>();
    area.add(State.CALIFORNIA.getAbbreviation());
    area.add(State.COLORADO.getAbbreviation());
    area.add(State.CONNECTICUT.getAbbreviation());
    String a = area.toString()
        .replace(" ","")
        .replace("[","")
        .replace("]","");
    ImmutableMap<String, String> params =
        ImmutableMap.<String, String>builder()
            .put("area",a)
            .put("certainty", "likely")
            .put("status", "actual")
            .put("limit", "3")
            .build();

    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(json.toString(), Alerts.class);
    AlertService service = WeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getActiveAlerts(params);
    Logger.getAnonymousLogger().info(callSync.request().url().toString());
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

    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(json.toString(), Alerts.class);
    AlertService service = TestWeatherServiceGenerator.createService(AlertService.class);
    Call<Alerts> callSync = service.getAlerts(params);
    try {
      Response<Alerts> response = callSync.execute();
      Alerts alertsResponse = response.body();
      assertEquals(alerts.toJson(false), alertsResponse.toJson(false));
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

    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(json.toString(), Alerts.class);
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
    //System.out.println(json);
    String a = json.toString();
    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(a, Alerts.class);
    
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

    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(json.toString(), Alerts.class);
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

    ObjectMapper mapper = new ObjectMapper();
    Alerts alerts = mapper.readValue(json.toString(), Alerts.class);
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

    ObjectMapper mapper =
        new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    Forecast rawData = mapper.readValue(json.toString(), Forecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<Forecast> callSync = service.getRawForecastData("TOP", 40, 60);
    try {
      Response<Forecast> response = callSync.execute();
      System.out.println(response.body().toJson(true));
      Forecast rawDataResponse = response.body();
      assertEquals(rawData, rawDataResponse);
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

    ObjectMapper mapper = new ObjectMapper();
    TextForecast forecast = mapper.readValue(json.toString(), TextForecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<TextForecast> callSync = service.getTextForecast("EAX", 50, 70, "si");
    try {
      Response<TextForecast> response = callSync.execute();
      System.out.println(response.body().toJson(false));
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

    ObjectMapper mapper = new ObjectMapper();
    TextForecast forecast = mapper.readValue(json.toString(), TextForecast.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
    Call<TextForecast> callSync = service.getTextForecast("TOP", 50, 70, "us");

    try {
      Response<TextForecast> response = callSync.execute();
      TextForecast textResponse = response.body();
      System.out.println(forecast.toJson(true));
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

    ObjectMapper mapper = new ObjectMapper();
    Stations forecast = mapper.readValue(json.toString(), Stations.class);
    GridpointsService service = TestWeatherServiceGenerator.createService(GridpointsService.class);
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

    ObjectMapper mapper = new ObjectMapper();
    StationFeature forecast = mapper.readValue(json.toString(), StationFeature.class);
    StationService service = WeatherServiceGenerator.createService(StationService.class);
    Call<StationFeature> callSync = service.getStation("KMYZ");
    try {
      Response<StationFeature> response = callSync.execute();

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

    ObjectMapper mapper = new ObjectMapper();
    PointData pointData = mapper.readValue(json.toString(), PointData.class);
    PointService service = WeatherServiceGenerator.createService(PointService.class);
    LngLatAlt coordinates = new LngLatAlt();
    coordinates.setLongitude(-96.6306);
    coordinates.setLatitude(39.8553);
    Point point = new Point();
    point.setCoordinates(coordinates);
    Logger.getLogger("PointsTest").info(point.toString());
    Call<PointData> callSync = service.getPointData(point);
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

    ObjectMapper mapper = new ObjectMapper();
    Products products = mapper.readValue(json.toString(), Products.class);
    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<Products> callSync = service.getProducts(params);
    try {
      Response<Products> response = callSync.execute();
      Products products1 = response.body();
      System.out.println(products1.toJson(false));

      assertEquals(products, products1);
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

    ObjectMapper mapper = new ObjectMapper();
    ProductLocations products = mapper.readValue(json.toString(), ProductLocations.class);

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

    ObjectMapper mapper = new ObjectMapper();
    ProductTypes products = mapper.readValue(json.toString(), ProductTypes.class);

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

    ObjectMapper mapper = new ObjectMapper();
    Products products = mapper.readValue(json.toString(), Products.class);

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

    ObjectMapper mapper = new ObjectMapper();
    ProductLocations products = mapper.readValue(json.toString(), ProductLocations.class);

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
  public void ProductTypesByLocationIDTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/productTypebylocation.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();
    ProductTypes products = mapper.readValue(json.toString(), ProductTypes.class);

    ProductsService service = TestWeatherServiceGenerator.createService(ProductsService.class);
    Call<ProductTypes> callSync = service.getProductTypesByLocationID("DTW");
    try {
      Response<ProductTypes> response = callSync.execute();

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

    ObjectMapper mapper = new ObjectMapper();
    Products products = mapper.readValue(json.toString(), Products.class);

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
        ImmutableMap.<String, String>builder()
            .put("area", "DE")
            .put("type", "land").build();

    ObjectMapper mapper = new ObjectMapper();
    Zones zones = mapper.readValue(json.toString(), Zones.class);
    ZoneService service = TestWeatherServiceGenerator.createService(ZoneService.class);
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

    ObjectMapper mapper = new ObjectMapper();
    Zones zones = mapper.readValue(json.toString(), Zones.class);
    //System.out.println(zones.toJson(false));
    ZoneService service = TestWeatherServiceGenerator.createService(ZoneService.class);
    Call<Zones> callSync = service.getZonesByType("land", params);
    try {
      Response<Zones> response = callSync.execute();
      Zones zoneResponse = response.body();

      //System.out.println(response.body().toJson(false));

      assertEquals(zones.toJson(false), zoneResponse.toJson(false));
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void ZoneForecastByIDTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/zoneforecastbyid.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();

    ZoneForecast zones = mapper.readValue(json.toString(), ZoneForecast.class);
    System.out.println(zones.toJson(true));
    ZoneService service = TestWeatherServiceGenerator.createService(ZoneService.class);
    Call<ZoneForecast> callSync = service.getZoneForecastByID("land", "MIZ001");
    try {
      Response<ZoneForecast> response = callSync.execute();
      ZoneForecast zoneResponse = response.body();

      System.out.println(response.body().toJson(false));

      assertEquals(zones, zoneResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void OfficeByIDTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/office.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();

    Office office = mapper.readValue(json.toString(), Office.class);

    OfficeService service = WeatherServiceGenerator.createService(OfficeService.class);
    Call<Office> callSync = service.getOfficeByID("CLE");
    try {
      Response<Office> response = callSync.execute();
      Office officeResponse = response.body();

      System.out.println(officeResponse.toJson(true));

      JSONAssert.assertEquals(office.toJson(false), officeResponse.toJson(false), false);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void HeadlineByIDTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/headlineByID.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();

    Headline office = mapper.readValue(json.toString(), Headline.class);

    OfficeService service = WeatherServiceGenerator.createService(OfficeService.class);
    Call<Headline> callSync =
        service.getOfficeHeadlineBYID("DTX", "061ecd7254f56401fc76554022c06ff5");
    try {
      Response<Headline> response = callSync.execute();
      Headline headlineResponse = response.body();

      System.out.println(headlineResponse.toJson(false));

      assertEquals(office, headlineResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  @SneakyThrows
  public void HeadlineTest() throws FileNotFoundException {
    FileInputStream input = new FileInputStream("src/test/resources/officeHeadline.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();

    OfficeHeadlines office = mapper.readValue(json.toString(), OfficeHeadlines.class);

    OfficeService service = TestWeatherServiceGenerator.createService(OfficeService.class);
    Call<OfficeHeadlines> callSync = service.getOfficeHeadlines("DTX");
    try {
      Response<OfficeHeadlines> response = callSync.execute();
      OfficeHeadlines headlineResponse = response.body();

      System.out.println(headlineResponse.toJson(false));

      assertEquals(office, headlineResponse);
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }

  @Test
  public void getObservationsTest() throws IOException {
    FileInputStream input = new FileInputStream("src/test/resources/observations.json");
    Scanner scanner = new Scanner(input);
    StringBuilder json = new StringBuilder();
    while (scanner.hasNext()) json.append(scanner.nextLine());

    ObjectMapper mapper = new ObjectMapper();

    ObservationFeature feature = mapper.readValue(json.toString(), ObservationFeature.class);

    StationService service = TestWeatherServiceGenerator.createService(StationService.class);
    Call<ObservationFeature> callSync = service.getObservations("GYGM4");

    try {
      Response<ObservationFeature> response = callSync.execute();
      ObservationFeature observationResponse = response.body();

      // System.out.println(feature.toJson(false));

      assertEquals(feature.toJson(false), observationResponse.toJson(false));
    } catch (IOException e) {
      Logger.getLogger(String.valueOf(callSync.getClass())).log(Level.SEVERE, e.getMessage());
    }
  }
}
