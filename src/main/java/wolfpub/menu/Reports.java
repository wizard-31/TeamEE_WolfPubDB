package main.java.wolfpub.menu;

import main.java.wolfpub.dao.ReportsHelper;

import java.util.Scanner;

/*
This class contains the code to display a menu for the Report section of the narrative.
Each operation in the narrative is shown as an option which the user can enter and see the output of. This is all done through the only function in the class run(). Please see the function for further information.
 */

public class Reports {

    // This function displays all the operations mentioned in the narrative of the project, and lists them out as options through a switch case statement in Java enclosed in a while loop. There is also an option for the user to exit this menu and return to the main menu of the application. The user can enter input taken through a Java Scanner for this.
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 12) {
            System.out.println("\n\nWelcome to the Wolfpub REPORTS! Please make your choice from the options below:\n");
            System.out.println("1. Generate monthly reports: number and total price of copies of each publication bought per distributor per month;");
            System.out.println("2. Total revenue of the publishing house");
            System.out.println("3. Total expenses (i.e., shipping costs and salaries)");
            System.out.println("4. Total expenses - ONLY shipping costs");
            System.out.println("5. Total expenses - ONLY salaries");
            System.out.println("6. Calculate the total current number of distributors");
            System.out.println("7. calculate total revenue (since inception) per city");
            System.out.println("8. calculate total revenue (since inception) per distributor");
            System.out.println("9. calculate total revenue (since inception) per location");
            System.out.println("10. Calculate total payments to the editors and authors, per time period");
            System.out.println("11. Calculate total payments to the editors and authors per work type (book authorship, article authorship, or editorial work)");
            System.out.println("12. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ReportsHelper.executeQuery1();
                    break;

                case 2:
                    ReportsHelper.executeQuery2();
                    break;

                case 3:
                    ReportsHelper.executeQuery3();
                    break;

                case 4:
                    ReportsHelper.executeQuery4();
                    break;

                case 5:
                    ReportsHelper.executeQuery5();
                    break;

                case 6:
                    ReportsHelper.executeQuery6();
                    break;

                case 7:
                    ReportsHelper.executeQuery7();
                    break;

                case 8:
                    ReportsHelper.executeQuery8();
                    break;

                case 9:
                    ReportsHelper.executeQuery9();
                    break;

                case 10:
                    ReportsHelper.executeQuery10();
                    break;

                case 11:
                    ReportsHelper.executeQuery11();
                    break;

                case 12:
                    System.out.println("Going back to main menu...\n");
                    return;

                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
        scanner.close();
        return;
    }
}