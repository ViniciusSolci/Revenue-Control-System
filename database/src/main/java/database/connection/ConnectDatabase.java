package database.connection;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    ConnectDatabase() {
    }

    private static Server sonicServer;
    static final String DB_LOCATION = "C:\\hsqldb-2.6.0\\hsqldb\\hsqldb\\";

    public static void startDBServer() {
        HsqlProperties props = new HsqlProperties();
        props.setProperty("server.database.0", "file:" + DB_LOCATION + "finalProjectDB;");
        props.setProperty("server.dbname.0", "finalProjectDB");
        sonicServer = new org.hsqldb.Server();
        try {
            sonicServer.setProperties(props);
        } catch (Exception e) {
            return;
        }
        sonicServer.start();
    }

    public static void stopDBServer() {
        sonicServer.shutdown();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/finalProjectDB", "SA", "");
    }
}