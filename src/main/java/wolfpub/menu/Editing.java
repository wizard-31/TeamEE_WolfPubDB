package main.java.wolfpub.menu;

import java.util.Scanner;

import main.java.wolfpub.WolfPubMain;
import main.java.wolfpub.dao.PublicationHelper;

public class Editing {
    public static void run() {
        try (Scanner scanner = new Scanner(System.in)) {
			int choice = 1;
			while (choice != 12) {
			    System.out.println("\n\nWelcome to the Wolfpub Editing and Publishing! Please make your choice from the options below:\n");
			    System.out.println("1. Enter basic information on a new publication;");
			    System.out.println("2. Update Information");
			    System.out.println("3. Assign Editor to a Publication");
			    System.out.println("4. View the publication that Editor is responsible for");
			    System.out.println("5. Edit table of contents of a publication, by adding/deleting articles or chapters");
			    System.out.println("6. Exit");
			    System.out.println();

			    choice = scanner.nextInt();
			    scanner.nextLine();
			    switch (choice) {
			        case 1:
			        	PublicationHelper.run();
			            break;

			        case 2:
			        	
			        	PublicationHelper.search();
			            break;
			        case 3:
			        	
			        	PublicationHelper.assign();
			            break;
			        case 4:
			        	
			        	PublicationHelper.view();
			            break;
			        case 5:
			        	
			        	PublicationHelper.tableofcontents();
			            break;


			      

			        case 6:
			            System.out.println("Going back to main menu...\n");
			            WolfPubMain.main(null);
			           
			        default:
			            System.out.println("Invalid option entered! Please enter a valid option.\n");
			    }
			}
		}
        return;

    }
}