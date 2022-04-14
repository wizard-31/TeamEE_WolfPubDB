package main.java.wolfpub.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
The DBHelper class contains functionalities used for connecting to the database, obtaining a connection from the database and closing a connection
 */
public class DBHelper {
    static final String jdbcURL = DBConnection.getDBURL();

    // This function is used to connect to the database and obtain a connection object to the database of the user whose connection information is obtained from the DBConnection class
  public static Connection getConnection() {
        try {
            // Load the driver.
            Class.forName("org.mariadb.jdbc.Driver");
            String user = DBConnection.getUsername();
            String passwd = DBConnection.getPassword();
            Connection conn = null;
            try {
                // Get a connection
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

    // Execute a query on the database - usually an update SQL statement
    public static int executeUpdate(String query) throws SQLException {
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            int ans = stmt.executeUpdate(query);
            close(conn);
            return ans;
        }
    }

    // Execute a query on the database - usually an update SQL statement
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

    // Close a connection to the database with the object provided.
    public static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    // Close a connection to the database with the object provided.
    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    // Close a connection to the database with the object provided.
    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }

}