
package gov.noaa;

import java.time.LocalDateTime;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Reference {

    private String id;
    private String identifier;
    private String sender;
    private LocalDateTime sent;

}
