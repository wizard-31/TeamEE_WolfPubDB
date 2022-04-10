package main.java.wolfpub.menu;

import main.java.wolfpub.dao.BookHelper;

import java.util.Scanner;

public class Books {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 12) {
            System.out.println("\n\n Welcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Enter a new Book Edition or New Issue of a Publication"); //DONE
            System.out.println("2. Display a Book Edition or Issue of a Publication"); //TO-DO: Sub menu with Topic, Date, Author's name
            System.out.println("3. Update a new Book Edition or New Issue of a Publication"); //TO-DO : Sub Menu needed
            System.out.println("4. Delete a new Book Edition or New Issue of a Publication"); //TO-DO: Sub menu with ID, Topic, Date, Author's name
            System.out.println("5. Enter a new Article or Chapter");
            System.out.println("6. Update an Article or a Chapter"); //TO-DO : Sub Menu with Title, Author Name, Topic and Date
            System.out.println("7. Enter Article's Text");
            System.out.println("8. Update an Article's Text");
            System.out.println("9. Display a new Book Edition or New Article"); //TO-DO: Sub menu with Topic, Date, Author's name
            System.out.println("10. Enter Payment for Author or Editor");
            System.out.println("11. Track Payment Claims");
            System.out.println("12. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BookHelper.createBook();
                    break;

                case 2:
                    BookHelper.displayBook(); //TO-DO Sub-Menus
                    break;

                case 3:
                    BookHelper.updateBook();
                    break;

                case 4:
//                    BooksHelper.executeQuery4();
                    break;

                case 5:
//                    BooksHelper.executeQuery5();
                    break;

                case 6:
//                    BooksHelper.executeQuery6();
                    break;

                case 7:
//                    BooksHelper.executeQuery7();
                    break;

                case 8:
//                    BooksHelper.executeQuery8();
                    break;

                case 9:
//                    BooksHelper.executeQuery9();
                    break;

                case 10:
//                    BooksHelper.executeQuery10();
                    break;

                case 11:
//                    BooksHelper.executeQuery11();
                    break;

                case 12:
                    System.out.println("Going back to main menu...\n");
                    return;

                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }

        return;

    }
}
