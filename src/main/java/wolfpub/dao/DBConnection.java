package main.java.wolfpub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static String getDBURL()
    {
        String DBURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/svenka25";
        return DBURL;
    }

    public static String getUsername()
    {
        String Username = "svenka25";
        return Username;
    }

    public static String getPassword()
    {
        String Password = "Subu_svenka25";
        return Password;
    }
}
