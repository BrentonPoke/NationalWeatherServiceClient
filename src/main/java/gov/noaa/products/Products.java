
package gov.noaa.products;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Products {
    
    @SerializedName("@graph")
    private List<Product> graph;
    
    @Data
    static class Product {
        
        private String id;
        private String issuanceTime;
        private String issuingOffice;
        private String productCode;
        private String productName;
        private String wmoCollectiveId;
        
    }

}
