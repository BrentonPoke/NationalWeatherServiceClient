package gov.noaa.points;

import org.geojson.Point;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointService {

  default Call<PointData> getPointData(Point point) {

    return getPointData(
        Double.toString(point.getCoordinates().getLatitude()).concat(",").concat(Double.toString(point.getCoordinates().getLongitude())));
  }

  @GET("/points/{point}")
  Call<PointData> getPointData(@Path(value = "point") String point);
}
