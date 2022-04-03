package main.java.wolfpub;

import java.sql.*;
import java.util.Scanner;

public class ReportsHelper {

    public static void printResultSet( ResultSet rs) {
        try {
            ResultSetMetaData rs_md = rs.getMetaData();
            int noCols = rs_md.getColumnCount();

            for (int i = 1; i <= noCols; i++) {
                System.out.print(rs_md.getColumnLabel(i) + " ");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= noCols; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery1() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("Select distributor_id,date_format(order_date, '%b-%y') as order_date, sum(quantity), round(sum(quantity*cost),2) totalcost from orders group by year(order_date), month(order_date),date_format(order_date, '%b-%y'),distributor_id;");
        printResultSet(rs);
        DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery2() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select sum(cost) from orders;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery3() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select sum(t1.cost) from ( (select sum(shipping_cost) cost from orders) union all (select sum(salary) cost from payments)) t1;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery4() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select round(sum(cost),2) revenue from orders;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery5() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select sum(salary) from payments;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery6() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select count(distributor_id) from distributor;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery7() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select city, round(sum(cost),2) as city_cost from orders natural join distributor group by city;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery8() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select distributor.name, round(sum(cost),2) as distributor_cost from orders natural join distributor group by orders.distributor_id;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery9() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select distributor.address as location , round(sum(cost),2) as location_cost from orders natural join distributor group by distributor.address;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery10() {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the start date to view salaries: ");
            String startDate = scanner.nextLine();

            System.out.println("Enter the end date to view salaries: ");
            String endDate = scanner.nextLine();

            Connection conn = DBHelper.getConnection();
            PreparedStatement selectStmt = conn.prepareStatement("select sum(salary) from payments natural join staff where payments.staff_id=staff.staff_id and payments.date_claimed between  ? and  ? ;");

            selectStmt.setString(1, startDate);
            selectStmt.setString(2, endDate);

            ResultSet rs = selectStmt.executeQuery();
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery11() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select sum(salary),type from payments natural join staff where payments.staff_id=staff.staff_id group by type;");
            printResultSet(rs);
            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}