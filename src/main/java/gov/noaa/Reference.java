
package gov.noaa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class Reference {

    private String id;
    private String identifier;
    private String sender;
    private String sent;

}
