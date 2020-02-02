
package gov.noaa.offices;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class Graph {

    private String content;
    private String id;
    private Boolean important;
    private String issuanceTime;
    private String link;
    private String name;
    private String office;
    private Object summary;
    private String title;

}
