package main.java.wolfpub.dao;

import java.sql.*;

public class DBHelper {

    static final String jdbcURL = DBConnection.getDBURL();

    public static Connection getConnection() {
        try {
            // Load the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MariaDB Thin
            // driver, available to clients.
            Class.forName("org.mariadb.jdbc.Driver");
            String user = DBConnection.getUsername();
            String passwd = DBConnection.getPassword();
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

    public static void close(Connection conn) {
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
