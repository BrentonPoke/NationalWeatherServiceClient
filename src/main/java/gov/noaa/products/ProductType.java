
package gov.noaa.products;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ProductType {
    @SerializedName("@graph")
    List<Type> graph;
    
    @Data
  static class Type {
    private String productCode;
    private String productName;
    }

}
