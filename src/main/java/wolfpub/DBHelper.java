package main.java.wolfpub;
import java.sql.*;

public class DBHelper {

    static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/<unity>";

    public static Connection getConnection() {
        try {

            // Load the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MariaDB Thin
            // driver, available to clients.
            Class.forName("org.mariadb.jdbc.Driver");
            String user = "<unity>";
            String passwd = "<password>";
            Connection conn = null;
            try {
                // Get a connection from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL
                conn = DriverManager.getConnection(jdbcURL, user, passwd);
                return conn;

            } catch (Exception e) {
                System.out.println("Exception in DBHelper getConnection()!");
                e.printStackTrace();
            }
        } catch(Throwable oops) {
            oops.printStackTrace();
        }
        return null;
    }

    static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }

}