
package gov.noaa.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class Products {
    
    @JsonProperty("@graph")
    private List<Product> graph;
    
    @Data
    @JsonIgnoreProperties(value = "@id")
     static class Product {
        
        private String id;
        private String issuanceTime;
        private String issuingOffice;
        private String productCode;
        private String productName;
        private String wmoCollectiveId;
    
        public Product() {
        }
    }
    public String toJson(){
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
