package us.juggl.twentyfifteen.december.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dphillips on 12/12/15.
 */
@Slf4j
public class PreparedStatementExample {

    public static void main(String... args) throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        final Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:simple", "SA", "");
        conn.createStatement().execute("CREATE TABLE users (ID BIGINT IDENTITY, GIVENNAME VARCHAR(120), FAMILYNAME VARCHAR(120));");
        final PreparedStatement s = conn.prepareStatement("INSERT INTO users (GIVENNAME, FAMILYNAME) values (?, ?)");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Deven", "Phillips"));
        people.add(new Person("Daniel", "Evensen"));
        people.add(new Person("Santosh", "Mandadi"));
        people.add(new Person("Joe", "Mackey"));
        people.add(new Person("Casin", "Hubbard"));

        people.stream().forEach(person -> {
            try {
                s.setString(1, person.givenName());
                s.setString(2, person.familyName());
                LOG.debug("Storing record for: "+person.toString());
                s.execute();
                s.clearParameters();
            } catch (SQLException sqle) {
                LOG.error(sqle.getLocalizedMessage(), sqle);
            }
        });
    }
}
