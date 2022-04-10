package main.java.wolfpub.dao;

import main.java.wolfpub.dao.DBHelper;
import static main.java.wolfpub.dao.ReportsHelper.*;

import static main.java.wolfpub.utils.PrintUtil.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;



public class BookHelper {
    static String insertBookSql = "INSERT INTO `distributor` (`phone_number`, `address`, `name`, `remaining_balance`, `city`, `type`, `contact_person`) VALUES ('%s', '%s', '%s', %f, '%s', '%s', '%s');";
    static String updateBookSql = "UPDATE `distributor` \n" +
            "SET `phone_number` = '%s', `address` = '%s', `name` = '%s', `remaining_balance` = '%f', `city` = '%s', `type` = '%s', `contact_person` = '%s'\n" +
            "WHERE `distributor_id` = %d;";
    static String deleteBookSql = "DELETE FROM `publication` WHERE `publication_id` = %d;";
    static String selectBookSql = "SELECT * FROM `books` WHERE `publication_id` = %d;";

    public static void createBook()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n Welcome to the WolfPub. Please enter the following details.");
            System.out.println("\nPublication ID: ");
            int pubId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Publication Type: ");
            String pubType = scanner.nextLine();
            System.out.println("Publication Topic: ");
            String pubTopic = scanner.nextLine();
            System.out.println("Publication Title: ");
            String pubTitle = scanner.nextLine();
            System.out.println("Publication Date(YYYY-MM-DD): ");
            String pubDate = scanner.nextLine();
            System.out.println("Publication ISBN: ");
            String pubISBN = scanner.nextLine();
            System.out.println("Publication Edition: ");
            String pubEdition = scanner.nextLine();

            Connection conn = DBHelper.getConnection();
            assert conn != null;
            PreparedStatement insertstmt = conn.prepareStatement("INSERT INTO books (`publication_id`, `publication_type`, `topic`, `title`, `publication_date`,`ISBN`, `Edition`) VALUES (?,?,?,?,?,?,?);");
            insertstmt.setInt(1, pubId);
            insertstmt.setString(2, pubType);
            insertstmt.setString(3, pubTopic);
            insertstmt.setString(4, pubTitle);
            insertstmt.setString(5, pubDate);
            insertstmt.setString(6,pubISBN);
            insertstmt.setString(7,pubEdition);
            int row = insertstmt.executeUpdate();
            DBHelper.close(conn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayBook()
    {
        //TO-DO Sub-Menus
        try
        {
            Connection conn = DBHelper.getConnection();
            Statement selectstmt = conn.createStatement();
            ResultSet rs = selectstmt.executeQuery("Select * from books;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Publication Id of the Book: ");
        int id = scanner.nextInt();
        try
        {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(String.format(selectBookSql, id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int choice = 1;
        loop:
        while (choice != 6) {
            System.out.println("\n Welcome to the WolfPub. Please select from the update following options.");
            System.out.println("\n 1. Topic");
            System.out.println("\n 2. Title");
            System.out.println("\n 3. Publication Date");
            System.out.println("\n 4. ISBN");
            System.out.println("\n 5. Edition");
            System.out.println("\n 6. Exit\n");
            System.out.println("Please enter your input: ");
            choice = scanner.nextInt();

            String stmt;
            switch (choice) {
                case 1:
                    stmt = "UPDATE books SET topic=? WHERE publication_id=?;";
                    break;
                case 2:
                    stmt = "UPDATE books SET title=? WHERE publication_id=?;";
                    break;
                case 3:
                    stmt = "UPDATE books SET publication_date=? WHERE publication_id=?;";
                    break;
                case 4:
                    stmt = "UPDATE books SET ISBN=? WHERE publication_id=?;";
                    break;
                case 5:
                    stmt = "UPDATE books SET Edition=? WHERE publication_id=?;";
                    break;
                case 6:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }

        //TO-DO Sub-Menus
        try {
            Connection conn = DBHelper.getConnection();
//            PreparedStatement insertstmt = conn.prepareStatement();
//            ResultSet rs = selectstmt.executeQuery("Select * from books;");
//            ArrayList<String[]> rsList = rsToList(rs);
//            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
}
