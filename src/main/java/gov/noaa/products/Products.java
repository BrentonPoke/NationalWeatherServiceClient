
package gov.noaa.products;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    public String toJson(boolean pretty){
        if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
    }
}
