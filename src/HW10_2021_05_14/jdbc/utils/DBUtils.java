package HW10_2021_05_14.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static String dbUrl = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:HW10_2021_05_14/jdbc/resource/init.sql'";
    private static String dbUsername = "sa";
    private static String dbPassword = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
