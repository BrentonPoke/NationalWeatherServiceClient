
package gov.noaa;

import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class WeatherServiceException extends IOException {

    private String correlationId;
    private String detail;
    private String instance;
    private Long status;
    private String title;
    private String type;

}
