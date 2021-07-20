package database.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesCreation {
    private TablesCreation() {
    }

    public static void run() throws SQLException, ClassNotFoundException {
        ConnectDatabase.startDBServer();

        Connection connection = ConnectDatabase.getConnection();
        try {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery("CREATE TABLE IF NOT EXISTS basic_level_student (id INT PRIMARY KEY, name VARCHAR(250), monthly_payment DOUBLE)");
                statement.executeQuery("CREATE TABLE IF NOT EXISTS services (id INT PRIMARY KEY, description VARCHAR(250), total_hours DOUBLE, hour_cost DOUBLE)");
                statement.executeQuery("CREATE TABLE IF NOT EXISTS superior_level_student (id INT PRIMARY KEY, name VARCHAR(250), total_credits DOUBLE, credits_cost DOUBLE)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

