package us.juggl.twentyfifteen.december.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by dphillips on 12/12/15.
 */
@Data
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class Person {

    private final String givenName;

    private final String familyName;
}
