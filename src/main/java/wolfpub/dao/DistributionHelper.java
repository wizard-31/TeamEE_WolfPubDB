package main.java.wolfpub.dao;

import main.java.wolfpub.dbobject.Distributor;
import main.java.wolfpub.dbobject.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static main.java.wolfpub.utils.PrintUtil.printResultSet;
import static main.java.wolfpub.utils.PrintUtil.rsToList;

public class DistributionHelper {

    final static String insertDistributorSql = "INSERT INTO `distributor` (`phone_number`, `address`, `name`, `remaining_balance`, `city`, `type`, `contact_person`) VALUES ('%s', '%s', '%s', %f, '%s', '%s', '%s');";
    final static String updateDistributorSql = "UPDATE `distributor` \n" +
            "SET `phone_number` = '%s', `address` = '%s', `name` = '%s', `remaining_balance` = '%f', `city` = '%s', `type` = '%s', `contact_person` = '%s'\n" +
            "WHERE `distributor_id` = %d;";
    final static String deleteDistributorSql = "DELETE FROM `distributor` WHERE `distributor_id` = %d;";
    final static String selectDistributorSql = "SELECT * FROM `distributor` WHERE `distributor_id` = %d;";
    final static String insertOrderSql = "INSERT INTO `orders` (`cost`, `shipping_cost`, `quantity`, `order_date`, `publication_id`, `distributor_id`, `delivery_date`) VALUES (%f, %f, %d, '%s', %d, %d, '%s');";
    final static String billOrderSql = "UPDATE distributor SET remaining_balance = remaining_balance + (select shipping_cost + cost from orders where order_id = %d) WHERE distributor_id= (select distributor_id from orders where order_id = %d);";
    final static String changeBalanceSql = "UPDATE distributor SET remaining_balance = remaining_balance - (select shipping_cost + cost from orders where order_id = %d) WHERE distributor_id= (select distributor_id from orders where order_id = %d);";

    /**
     * This function shows all distributors in the database
     */
    public static void showDistributors() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("Select * from distributor;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function inserts a new distributor to database
     */
    public static void insertDistributor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Name");
        String name = scanner.nextLine();
        System.out.println("Input Type(wholesale distributor, bookstore, library)");
        String type = scanner.nextLine();
        System.out.println("Input Street Address");
        String address = scanner.nextLine();
        System.out.println("Input City");
        String city = scanner.nextLine();
        System.out.println("Input Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Input Contact Person");
        String contactPerson = scanner.nextLine();
        System.out.println("Input Balance");
        float balance = scanner.nextFloat();
        Distributor distributor = new Distributor(phoneNumber, address, name, balance, city, type, contactPerson);
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            selectStmt.executeQuery(String.format(insertDistributorSql, distributor.getPhoneNumber(), distributor.getAddress(), distributor.getName(), distributor.getRemainingBalance(), distributor.getCity(), distributor.getType(), distributor.getContactPerson()));
            DBHelper.close(conn);
            System.out.println("Enter new distributor successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function updates distributor information by id
     */
    public static void updateDistributor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Distributor Id");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(String.format(selectDistributorSql, id));
            ArrayList<String[]> rsList = rsToList(rs);
            String[] attributes = rsList.get(1);
            Distributor distributor = new Distributor(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3], Float.parseFloat(attributes[5]), attributes[6], attributes[7], attributes[4]);
            int choice = 1;
            while(choice != 8){
                System.out.println("Choose the attribute you want to update");
                System.out.println("1: name");
                System.out.println("2: type");
                System.out.println("3: street address");
                System.out.println("4: city");
                System.out.println("5: phone number");
                System.out.println("6: contact person");
                System.out.println("7: balance");
                System.out.println("8: finish update");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("Input name:");
                        String name = scanner.nextLine();
                        distributor.setName(name);
                        break;
                    case 2:
                        System.out.println("Input type(wholesale distributor, bookstore, library):");
                        distributor.setType(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Input street address:");
                        distributor.setAddress(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Input city:");
                        distributor.setCity(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Input phone number:");
                        distributor.setPhoneNumber(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Input contact person:");
                        distributor.setContactPerson(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Input balance:");
                        distributor.setRemainingBalance(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Invalid option entered! Please enter a valid option.\n");
                }
            }
            selectStmt.executeUpdate(String.format(updateDistributorSql, distributor.getPhoneNumber(), distributor.getAddress(), distributor.getName(), distributor.getRemainingBalance(), distributor.getCity(), distributor.getType(), distributor.getContactPerson(), distributor.getDistributorID()));
            DBHelper.close(conn);
            System.out.println("Update distributor successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function deletes distributor by id
     */
    public static void deleteDistributor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Distributor Id");
        int id = scanner.nextInt();
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            selectStmt.executeQuery(String.format(deleteDistributorSql, id));
            DBHelper.close(conn);
            System.out.println("Delete distributor successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function inserts an order from distributor for a book edition or an issue of a publication per distributor, for a certain date
     */
    public static void inputOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Distributor Id");
        int distributorId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input Publication Id");
        int publicationId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input number of copies");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input Order Date(format: yyyy-mm-dd)");
        String orderDate = scanner.nextLine();
        System.out.println("Input Delivery Date(format: yyyy-mm-dd)");
        String deliveryDate = scanner.nextLine();
        System.out.println("Input price per copy");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input shipping cost");
        double shippingCost = scanner.nextDouble();
        scanner.nextLine();
        Order order = new Order(price*quantity, shippingCost, quantity, orderDate, publicationId, distributorId, deliveryDate);
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            selectStmt.executeQuery(String.format(insertOrderSql, order.getCost(), order.getShippingCost(), order.getQuantity(), order.getOrderDate(), order.getPublicationId(), order.getDistributorId(), order.getDeliveryDate()));
            DBHelper.close(conn);
            System.out.println("Input order successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function bills distributor for an order
     */
    public static void billOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Order Id");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            selectStmt.executeUpdate(String.format(billOrderSql, orderId, orderId));
            DBHelper.close(conn);
            System.out.println("Bill distributor for an order successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function changes outstanding balance of a distributor on receipt of a payment.
     */
    public static void changeBalance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Order Id");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            selectStmt.executeUpdate(String.format(changeBalanceSql, orderId, orderId));
            DBHelper.close(conn);
            System.out.println("Change outstanding balance of a distributor on receipt of a payment successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function shows all orders in the database
     */
    public static void showOrders() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("Select * from orders;");
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
