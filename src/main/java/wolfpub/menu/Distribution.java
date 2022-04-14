package main.java.wolfpub.menu;

import main.java.wolfpub.dao.DistributionHelper;

import java.util.Scanner;

public class Distribution {

    /**
     * Menu for Distribution part
     */
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 12) {
            System.out.println("\n\nWelcome to the Wolfpub Distribution! Please make your choice from the options below:\n");
            System.out.println("1. Show distributors");
            System.out.println("2. Enter new distributor");
            System.out.println("3. Update distributor information");
            System.out.println("4. Delete a distributor");
            System.out.println("5. Input orders from distributors");
            System.out.println("6. Bill distributor for an order");
            System.out.println("7. Change outstanding balance of a distributor on receipt of a payment");
            System.out.println("8. Show orders");
            System.out.println("9. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    DistributionHelper.showDistributors();
                    break;
                case 2:
                    DistributionHelper.insertDistributor();
                    break;
                case 3:
                    DistributionHelper.updateDistributor();
                    break;
                case 4:
                    DistributionHelper.deleteDistributor();
                    break;
                case 5:
                    DistributionHelper.inputOrder();
                    break;
                case 6:
                    DistributionHelper.billOrder();
                    break;
                case 7:
                    DistributionHelper.changeBalance();
                    break;
                case 8:
                    DistributionHelper.showOrders();
                    break;
                case 9:
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
