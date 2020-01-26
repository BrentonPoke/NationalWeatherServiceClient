
package gov.noaa.products;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class ProductTypes {
    @SerializedName("@graph")
    List<Type> graph;
    
    @Data
  static class Type {
    private String productCode;
    private String productName;
    }
  public String toJson(boolean pretty){
    if(pretty)
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
        else
            return new Gson().toJson(this);
  }
}
