package com.test.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class TestConnections {

private TestConnections() {}

    /** Returns an H2 in-memory Connection configured to be compatible with MySQL syntax. */
    public static Connection h2MySqlMode() throws SQLException {
        // DATABASE_TO_UPPER=false keeps column names as defined; DB_CLOSE_DELAY=-1 keeps DB alive for JVM lifetime
        String url = "jdbc:h2:mem:empdb;MODE=MySQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1";
        return DriverManager.getConnection(url, "sa", "");
    }

}
