
package gov.noaa.glossary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class GlossaryItem {

    private String definition;
    private String term;

}
