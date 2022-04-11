package main.java.wolfpub.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBHelper {

    static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/hselvar2";

    public static Connection getConnection() {
        try {

            // Load the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MariaDB Thin
            // driver, available to clients.
            Class.forName("org.mariadb.jdbc.Driver");
            String user = "hselvar2";
            String passwd = "200366498";
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
    
    public static int executeUpdate(String query) throws SQLException {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            int ans = stmt.executeUpdate(query);
            close(conn);
            return ans;
        }
    }
    
    public static List<Object[]> executeQueryUpdated(String query) throws SQLException {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            List<Object[]> resultList = new ArrayList();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            while(rs.next()) {
                Object[] items = new Object[count];
                for(int i=0; i< count; i++) {
                    items[i] = rs.getObject(i+1);
                }
                resultList.add(items);
            }
            close(conn);
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
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