
package gov.noaa.models.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.GsonBuilder;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class Products {
    
    @JsonProperty("@graph")
    private List<Product> products;
    
    @Data
    @JsonIgnoreProperties(value = "@id")
     static class Product {
        
        private String id;
        private ZonedDateTime issuanceTime;
        private String issuingOffice;
        private String productCode;
        private String productName;
        private String wmoCollectiveId;
        public void setIssuanceTime(String timestamp){
          this.issuanceTime = ZonedDateTime.parse(timestamp);
        }
    
        public Product() {
        }
    }
  public String toJson(boolean pretty) {
    GsonBuilder gsonBuilder = new GsonBuilder();
    if (pretty)
      gsonBuilder
          .setPrettyPrinting();
    return gsonBuilder
        .serializeSpecialFloatingPointValues()
        .create()
        .toJson(this);
  }
}
