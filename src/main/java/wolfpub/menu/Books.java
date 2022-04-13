package main.java.wolfpub.menu;

import main.java.wolfpub.dao.*;
import java.util.Scanner;

public class Books {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 10) {
            System.out.println("\n\n Welcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Enter a new Book Edition or New Issue of a Publication");
            System.out.println("2. Display a Book Edition or Issue of a Publication"); //TODO Sub Menu
            System.out.println("3. Update a new Book Edition or New Issue of a Publication");
            System.out.println("4. Delete a new Book Edition or New Issue of a Publication");
            System.out.println("5. Enter a new Article or Chapter");
            System.out.println("6. Update an Article or a Chapter");
            System.out.println("7. Enter Authors for Article");
            System.out.println("8. Enter Payment for Author or Editor");
            System.out.println("9. Track Payment Claims");
            System.out.println("10. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1: BookHelper.createBookOrIssue(); break;
                case 2: BookHelper.displayBookOrIssue(); break;
                case 3: BookHelper.updateBookOrIssue(); break;
                case 4: BookHelper.deleteBookOrIssue(); break;
                case 5: BookHelper.createChapterOrArticle(); break;
                case 6: BookHelper.updateChapterOrArticle(); break;
                case 7: BookHelper.enterAuthorForPublications(); break;
                case 8: BookHelper.insertPaymentEditorAuthor(); break;
                case 9: BookHelper.trackPaymentClaims(); break;
                case 10:
                    System.out.println("Going back to main menu...\n");
                    return;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }
}
