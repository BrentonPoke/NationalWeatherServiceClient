package gov.noaa.models.glossary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GlossaryService {
  @GET("/glossary")
  public Call<Glossary> getGlossaryItems();
}
