package main.java.wolfpub;

import java.sql.Connection;
import java.util.Scanner;
import main.java.wolfpub.*;
import main.java.wolfpub.menu.Reports;
import main.java.wolfpub.menu.Editing;

public class WolfPubMain {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int choice = 1;
        loop: while(choice != 5) {
            System.out.println("Welcome to the Wolfpub Application! Please make your choice from the options below:\n");

            System.out.println("1. Editing and Publishing");
            System.out.println("2. Production of a book edition or of an issue of a publication");
            System.out.println("3. Distribution");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            System.out.println();

            System.out.println("Please enter your input: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    //TO DO: add call to editing and publishing here
                	 System.out.println("Going to Publication...\n");
                	 Editing.run();
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
                    break loop;

                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }

        }
        return;
    }
}