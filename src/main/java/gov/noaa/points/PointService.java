package gov.noaa.points;

import com.github.filosganga.geogson.model.Point;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointService {

  default Call<PointData> getPointData(Point point) {

    return getPointData(
        Double.toString(point.lat()).concat(",").concat(Double.toString(point.lon())));
  }

  @GET("/points/{point}")
  Call<PointData> getPointData(@Path(value = "point") String point);
}
