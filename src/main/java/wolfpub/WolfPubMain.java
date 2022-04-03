package main.java.wolfpub;

import java.sql.Connection;
import java.util.Scanner;

public class WolfPubMain {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int choice = 1;
        while(choice != 5) {
            System.out.println("Welcome to the Wolfpub Application! Please make your choice from the options below:\n");

            System.out.println("1. Editing and Publishing");
            System.out.println("2. Production of a book edition or of an issue of a publication");
            System.out.println("3. Distribution");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    //TO DO: add call to editing and publishing here
                    break;

                case 2:
                    //TO DO: add call Production of book edtion or publication issue
                    break;


                case 3:
                    //TO DO: add call Distribution
                    break;

                case 4:
                    System.out.println("Going to Reports...\n");
                    Reports.run();
                    break;

                case 5:
                    Connection conn = DBHelper.getConnection();
                    DBHelper.close(conn);
                    break;

                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }

        }
        return;
    }
}
