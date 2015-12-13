package us.juggl.twentyfifteen.december.jdbc;

import java.sql.*;

/**
 * Created by dphillips on 12/12/15.
 */
public class SimpleJDBCExample {

    public static void main(String... args) throws Exception {
        PreparedStatementExample.main();
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:simple");
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM users");

        while (r.next()) {
            System.out.println(r.getString("GIVENNAME"));
        }
    }
}
