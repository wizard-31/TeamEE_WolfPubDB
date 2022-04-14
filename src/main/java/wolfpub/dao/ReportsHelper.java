package main.java.wolfpub.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import static main.java.wolfpub.utils.PrintUtil.*;

/*
The reports helper class contains all the code for the execution of all the operations in the Reports Section of the narrative. This is used in the Reports class in the menu directory. Please see below for information about each function in the class.
 */
public class ReportsHelper {

    /*
    This function handles the following operation in the narrative:
    Generate monthly reports: number and total price of copies of each publication bought per distributor per month;
    It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
     */
        public static void executeQuery1() {

        try {
            System.out.println("number and total price of copies of each publication bought per distributor per month");
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("Select distributor_id,date_format(order_date, '%b-%y') as order_date, sum(quantity) as quantity, round(cost,2) totalcost from orders group by year(order_date), month(order_date),date_format(order_date, '%b-%y'),distributor_id;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    This function handles the following operation in the narrative:
   Generate monthly reports: Total revenue of the publishing house
    It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
     */
    public static void executeQuery2() {
        try {
            System.out.println("Total revenue of the publishing house");
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select sum(cost) as total_revenue from orders;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    This function handles the following operation in the narrative:
    Generate monthly reports: Total expenses (i.e., shipping costs and salaries)
     It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
     */
    public static void executeQuery3() {
        try {
            System.out.println("Total expenses (i.e., shipping costs and salaries)");
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select sum(t1.cost) as shipping_costs_and_salaries from ( (select sum(shipping_cost) cost from orders) union all (select sum(salary) cost from payments)) t1;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
    Generate monthly reports: Total expenses - ONLY shipping costs
 It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery4() {
        try {
            System.out.println(" Total expenses - ONLY shipping costs");
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select round(sum(cost),2) as shipping_costs from orders;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
   Generate monthly reports: Total expenses - ONLY salaries
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery5() {
        try {
            System.out.println("  Total expenses - ONLY salaries");

            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select sum(salary) as salaries from payments;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
   Generate monthly reports: Calculate the total current number of distributors
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery6() {
        try {
            System.out.println("  Calculate the total current number of distributors");

            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select count(distributor_id) as number_of_distributors from distributor;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
Generate monthly reports:  calculate total revenue (since inception) per city
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery7() {
        try {
            System.out.println(" calculate total revenue (since inception) per city");
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select city, round(sum(cost),2) as city_cost from orders natural join distributor group by city;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
Generate monthly reports: calculate total revenue (since inception) per distributor
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery8() {
        try {
            System.out.println("  total revenue (since inception) per distributor");

            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select distributor.name, round(sum(cost),2) as distributor_cost from orders natural join distributor group by orders.distributor_id;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
Generate monthly reports: calculate total revenue (since inception) per location
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery9() {
        try {
            System.out.println("total revenue (since inception) per location");

            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select distributor.address as location , round(sum(cost),2) as location_cost from orders natural join distributor group by distributor.address;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
Generate monthly reports: Calculate total payments to the editors and authors, per time period
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery10() {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the start date(yyyy-mm-dd)  to view salaries: ");
            String startDate = scanner.nextLine();

            System.out.println("Enter the end date(yyyy-mm-dd) to view salaries: ");
            String endDate = scanner.nextLine();
            System.out.println("total payments to the editors and authors, per time period");

				Connection conn = DBHelper.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement("select sum(salary) as total_payment  from payments natural join staff where payments.staff_id=staff.staff_id and payments.date_claimed between  ? and  ? ;");

				selectStmt.setString(1, startDate);
				selectStmt.setString(2, endDate);

				ResultSet rs = selectStmt.executeQuery();
				ArrayList<String[]> rsList = rsToList(rs);
				printResultSet(rsList);
				DBHelper.close(conn);
			} catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
This function handles the following operation in the narrative:
Generate monthly reports:Calculate total payments to the editors and authors per work type (book authorship, article authorship, or editorial work)
It does so by creating a connection to the database, which it uses to run the query for this operation, and then obtaining and printing the ResultSet obtained from executing said query. It uses functions from the PrintUtil class for this.
 */
    public static void executeQuery11() {
        try {
            System.out.println("total payments to the editors and authors per work type (book authorship, article authorship, or editorial work)");

            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select sum(salary) as total_payments,type from payments natural join staff where payments.staff_id=staff.staff_id group by type;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}