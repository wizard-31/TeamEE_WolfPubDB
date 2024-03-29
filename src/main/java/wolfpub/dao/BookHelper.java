package main.java.wolfpub.dao;

import main.java.wolfpub.dbobject.*;
import static main.java.wolfpub.utils.PrintUtil.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
The Book helper class contains all the necessary functions required for the operations in the
"Production of a book edition or of an issue of a publication" part of the narrative.
This file is used in the Books.java file's menu directory.
*/

public class BookHelper {
    //Select Queries for operations
    static String selectBookSql = "SELECT * FROM `books` WHERE `publication_id` = %d;";
    static String selectIssueSql = "SELECT * FROM `issue` WHERE `publication_id` = %d;";
    static String selectChapterSql = "SELECT * FROM `chapter` WHERE `publication_id` = %d AND `chapter_id` = %d;";
    static String selectArticleSql = "SELECT * FROM `article` WHERE `article_id` = %d;";
    static String selectPaymentAddresseeSql = "SELECT * FROM `payments` natural join `staff` WHERE `staff_id` = %d;";
    //Insert Queries for operations
    static String insertBookSql = "INSERT INTO `books` (`publication_id`, `publication_type`, `topic`, `title`, `publication_date`,`ISBN`, `Edition`) VALUES (?,?,?,?,?,?,?);";
    static String insertIssueSql = "INSERT INTO `issue` (`publication_id`, `publication_type`, `topic`, `title`, `publication_date`,`periodicity`) VALUES (?,?,?,?,?,?);";
    static String insertArticleSql = "INSERT INTO `article` (`topic`,`content`) VALUES (?,?);";
    static String insertChapterSql = "INSERT INTO `chapter` (`publication_id`,`chapter_id`,`chapter_text`) VALUES (?,?,?);";
    static String insertPaymentsSql = "INSERT INTO `payments`(`staff_id`, `salary`,`date_claimed`) VALUES (?,?,?);";
    static String insertAuthorToBook = "INSERT INTO `writes_books` (`staff_id`,`publication_id`) VALUES (?,?);";
    static String insertAuthorToArticles = "INSERT INTO `writes_articles` (`staff_id`,`article_id`) VALUES (?,?);";
    static String insertAuthorToChapters = "INSERT INTO `writes_chapters` (`staff_id`,`publication_id`,`chapter_id`) VALUES (?,?,?);";
    //Update Queries for operations
    static String updateBookSql = "UPDATE `books` SET `Edition` = ?, `topic` = ?, `title` = ?, `publication_date` = ?, `ISBN` = ? WHERE `publication_id` = ?;";
    static String updatePublicationSql = "UPDATE `publication` SET `topic` = ?, `title` = ?, `publication_date` = ? WHERE `publication_id` = ?;";
    static String updateIssueSql = "UPDATE `issue` SET `topic` = ?, `title` = ?, `publication_date` = ?, `periodicity` = ? WHERE `publication_id` = ?;";
    static String updateChapterSql = "UPDATE `chapter` SET `chapter_text` = ? WHERE `publication_id` = ? AND `chapter_id` = ?;";
    static String updateArticleSql = "UPDATE `article` SET `topic` = ?, `content` = ? WHERE `article_id`=?;";
    //Delete Queries for operations
    static String deletePublicationSql = "DELETE FROM `publication` WHERE `publication_id` = %d;";

    /*
    This function handles creation of a Book or an Issue. It uses the insertBookSql
    and insertIssueSql commands declared above, and utilizes the DBHelper file to create and close DB connections.
    */
    public static void createBookOrIssue() {
        System.out.println("\nCreate Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Create Book");
            System.out.println("2. Create Issue");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            int id, pubId;
            String pubType, pubTopic, pubTitle, pubDate;

            switch (choice) {
                case 1:
                    System.out.println("Creating Book...");
                    System.out.println("\nPublication ID: ");
                    pubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Publication Type(Book): ");
                    pubType = scanner.nextLine();
                    System.out.println("Publication Topic: ");
                    pubTopic = scanner.nextLine();
                    System.out.println("Publication Title: ");
                    pubTitle = scanner.nextLine();
                    System.out.println("Publication Date(YYYY-MM-DD): ");
                    pubDate = scanner.nextLine();
                    System.out.println("Publication ISBN: ");
                    String pubISBN = scanner.nextLine();
                    System.out.println("Publication Edition: ");
                    String pubEdition = scanner.nextLine();

                    Book book = new Book(pubId, pubType, pubTopic, pubTitle, pubDate, pubISBN, pubEdition);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertBookSql);
                        insertstmt.setInt(1, book.getPublicationID());
                        insertstmt.setString(2, book.getPublicationType());
                        insertstmt.setString(3, book.getTopic());
                        insertstmt.setString(4, book.getTitle());
                        insertstmt.setString(5, book.getPublicationDate());
                        insertstmt.setString(6, book.getISBN());
                        insertstmt.setString(7, book.getEdition());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Creating Issue...");
                    System.out.println("\nPublication ID: ");
                    pubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Publication Type: ");
                    pubType = scanner.nextLine();
                    System.out.println("Publication Topic: ");
                    pubTopic = scanner.nextLine();
                    System.out.println("Publication Title: ");
                    pubTitle = scanner.nextLine();
                    System.out.println("Publication Date(YYYY-MM-DD): ");
                    pubDate = scanner.nextLine();
                    System.out.println("Publication's Periodicity (weekly/bi-weekly/monthly) : ");
                    String pubPeriod = scanner.nextLine();

                    Issue issue = new Issue(pubId, pubType, pubTopic, pubTitle, pubDate, pubPeriod);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertIssueSql);
                        insertstmt.setInt(1, issue.getPublicationID());
                        insertstmt.setString(2, issue.getPublicationType());
                        insertstmt.setString(3, issue.getTopic());
                        insertstmt.setString(4, issue.getTitle());
                        insertstmt.setString(5, issue.getPublicationDate());
                        insertstmt.setString(6, issue.getPeriodicity());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function displays Books or Issues based on the choice entered - topic, date, author's name.
    It uses the selectBookSql and selectIssueSql commands declared above, and utilizes the DBHelper file to create
    and close DB connections.
    */
    public static void displayBookOrIssue() {
        System.out.println("\nDisplay Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Display Book");
            System.out.println("2. Display Issue");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            int id;
            int updateChoice =1;
            String displayString;
            switch (choice) {
                case 1:
                    System.out.println("Displaying Book...");
                    while(updateChoice!=5)
                    {
                        System.out.println("Choose the condition by which you'd like to display");
                        System.out.println("1. Topic");
                        System.out.println("2. Title");
                        System.out.println("3. Publication Date");
                        System.out.println("4. Author's Name");
                        System.out.println("5. Exit");
                        updateChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (updateChoice) {
                            case 1:
                                System.out.println("Enter Topic to search by: ");
                                String displayTopic = scanner.nextLine();
                                displayString = "Select * from `books` where `topic`='"+displayTopic+"';";
                                displayFunction(displayString);
                                break;
                            case 2:
                                System.out.println("Enter Title to search by: ");
                                String displayTitle = scanner.nextLine();
                                displayString = "Select * from `books` where `title`='"+displayTitle+"';";
                                displayFunction(displayString);
                                break;
                            case 3:
                                System.out.println("Enter Publication Date to search by: ");
                                String displayPubDate = scanner.nextLine();
                                displayString = "Select * from `books` where `publication_date`='"+displayPubDate+"';";
                                displayFunction(displayString);
                                break;
                            case 4:
                                System.out.println("Enter Author's Name to search by: ");
                                String authorName = scanner.nextLine();
                                displayString = "Select name, books.topic, books.title,books.publication_date,ISBN, Edition from (books natural join writes_books) natural join staff where staff.name ='"+authorName+"';";
                                displayFunction(displayString);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option entered! Please enter a valid option.\n");

                        }
                    }
                    break;
                case 2:
                    System.out.println("Displaying Issue...");
                    while(updateChoice!=6)
                    {
                        System.out.println("Choose the condition by which you'd like to display");
                        System.out.println("1. Topic");
                        System.out.println("2. Title");
                        System.out.println("3. Publication Date");
                        System.out.println("4. Periodicity");
                        System.out.println("5. Author's Name");
                        System.out.println("6. Exit");
                        updateChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (updateChoice) {
                            case 1:
                                System.out.println("Enter Topic to search by: ");
                                String displayTopic = scanner.nextLine();
                                displayString = "Select * from `issue` where `topic`='"+displayTopic+"';";
                                displayFunction(displayString);
                                break;
                            case 2:
                                System.out.println("Enter Title to search by: ");
                                String displayTitle = scanner.nextLine();
                                displayString = "Select * from `issue` where `title`='"+displayTitle+"';";
                                displayFunction(displayString);
                                break;
                            case 3:
                                System.out.println("Enter Publication Date to search by: ");
                                String displayPubDate = scanner.nextLine();
                                displayString = "Select * from `issue` where `publication_date`='"+displayPubDate+"';";
                                displayFunction(displayString);
                                break;
                            case 4:
                                System.out.println("Enter Periodicity to search by: ");
                                String displayPeriodicity = scanner.nextLine();
                                displayString = "Select * from `issue` where `periodicity`='"+displayPeriodicity+"';";
                                displayFunction(displayString);
                                break;
                            case 5:
                                System.out.println("Enter Author's Name to search by: ");
                                String authorName = scanner.nextLine();
                                displayString = "Select name, issue.topic, issue.title,issue.publication_date,issue.periodicity from ((issue natural join contains) natural join staff) natural join writes_articles where staff.name ='"+authorName+"';";
                                displayFunction(displayString);
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid option entered! Please enter a valid option.\n");
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function updates Book or Issue using the updateBookSql, updateIssueSql and updatePublicationSql commands
    declared above. Since Books and Issues are part of Publications via an is-a relationship. Any changes made to Books
    or Issues are automatically reflected in Publications as well.
    The function utilizes the DBHelper file to create and close DB connections.
     */
    public static void updateBookOrIssue() {
        System.out.println("\nUpdate Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Update Book");
            System.out.println("2. Update Issue");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Updating Book...\n");
                    System.out.println("Input Publication Id of the Book: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Connection conn = DBHelper.getConnection();
                    try {
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery(String.format(selectBookSql, id));
                        ArrayList<String[]> rsList = rsToList(rs);
                        String[] attributes = rsList.get(1);
                        Book book = new Book(id, attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6]);
                        Publication publication = new Publication(id, attributes[1], attributes[2], attributes[3], attributes[4]);

                        int updatechoice = 1;
                        while (updatechoice != 6) {
                            System.out.println("Choose the attribute you'd like to update");
                            System.out.println("1. Topic");
                            System.out.println("2. Title");
                            System.out.println("3. Publication Date");
                            System.out.println("4. ISBN");
                            System.out.println("5. Edition");
                            System.out.println("6: Finish Update");
                            updatechoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (updatechoice) {
                                case 1:
                                    System.out.println("Enter new Topic: ");
                                    String newTopic = scanner.nextLine();
                                    book.setTopic(newTopic);
                                    publication.setTopic(newTopic);
                                    break;
                                case 2:
                                    System.out.println("Enter new Title: ");
                                    String newTitle = scanner.nextLine();
                                    book.setTitle(newTitle);
                                    publication.setTitle(newTitle);
                                    break;
                                case 3:
                                    System.out.println("Enter new Publication Date (YYYY-MM-DD): ");
                                    String newPubDate = scanner.nextLine();
                                    book.setPublicationDate(newPubDate);
                                    publication.setPublicationDate(newPubDate);
                                    break;
                                case 4:
                                    System.out.println("Enter new ISBN: ");
                                    String newISBN = scanner.nextLine();
                                    book.setISBN(newISBN);
                                    break;
                                case 5:
                                    System.out.println("Enter new Edition: ");
                                    String newEdition = scanner.nextLine();
                                    book.setEdition(newEdition);
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Invalid option entered! Please enter a valid option.\n");
                            }
                        }

                        PreparedStatement updatestmt1 = conn.prepareStatement(updateBookSql);
                        PreparedStatement updatestmt2 = conn.prepareStatement(updatePublicationSql);

                        //Begin Transaction Block
                        conn.setAutoCommit(false);
                        updatestmt1.setString(1, book.getEdition());
                        updatestmt1.setString(2, book.getTopic());
                        updatestmt1.setString(3, book.getTitle());
                        updatestmt1.setString(4, book.getPublicationDate());
                        updatestmt1.setString(5, book.getISBN());
                        updatestmt1.setInt(6, book.getPublicationID());

                        //first query
                        int row1 = updatestmt1.executeUpdate();
                        updatestmt2.setString(1, publication.getTopic());
                        updatestmt2.setString(2, publication.getTitle());
                        updatestmt2.setString(3, publication.getPublicationDate());
                        updatestmt2.setInt(4, publication.getPublicationID());

                        //second query
                        int row2 = updatestmt2.executeUpdate();

                        if(row1 == row2)
                        {
                            System.out.println("Success...");
                        }
                        else
                        {
                            System.out.println("Failure...");
                            throw new Exception("something about transactions!");
                        }

                        conn.commit();

                    } catch (Exception e) {
                        //e.printStackTrace();
                        System.out.println("Transaction Failed. Doing a Rollback.....");
                        try{
                            System.err.print("Transaction rolled back.");
                            // rollback
                            conn.rollback();
                        }
                        catch(SQLException e2){
                            //e2.printStackTrace();
                        }
                    }
                    // End Transaction Block
                    finally {
                        DBHelper.close(conn);
                    }
                    break;
                case 2:
                    System.out.println("Updating Issue...");
                    System.out.println("Input Publication Id of Issue: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    conn = DBHelper.getConnection();
                    try {
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery(String.format(selectIssueSql, id));
                        ArrayList<String[]> rsList = rsToList(rs);
                        String[] attributes = rsList.get(1);
                        Issue issue = new Issue(id, attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]);
                        Publication publication = new Publication(id, attributes[1], attributes[2], attributes[3], attributes[4]);

                        int updatechoice = 1;
                        while (updatechoice != 5) {
                            System.out.println("Choose the attribute you'd like to update");
                            System.out.println("1. Topic");
                            System.out.println("2. Title");
                            System.out.println("3. Publication Date");
                            System.out.println("4. Periodicity");
                            System.out.println("5: Finish Update");
                            updatechoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (updatechoice) {
                                case 1:
                                    System.out.println("Enter new Topic: ");
                                    String newTopic = scanner.nextLine();
                                    issue.setTopic(newTopic);
                                    publication.setTopic(newTopic);
                                    break;
                                case 2:
                                    System.out.println("Enter new Title: ");
                                    String newTitle = scanner.nextLine();
                                    issue.setTitle(newTitle);
                                    publication.setTitle(newTitle);
                                    break;
                                case 3:
                                    System.out.println("Enter new Publication Date (YYYY-MM-DD): ");
                                    String newPubDate = scanner.nextLine();
                                    issue.setPublicationDate(newPubDate);
                                    publication.setPublicationDate(newPubDate);
                                    break;
                                case 4:
                                    System.out.println("Enter new Periodicity(weekly/bi-weekly/monthly): ");
                                    String newPeriodicity = scanner.nextLine();
                                    issue.setPeriodicity(newPeriodicity);
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Invalid option entered! Please enter a valid option.\n");
                            }
                        }

                        PreparedStatement updatestmt1 = conn.prepareStatement(updateIssueSql);
                        PreparedStatement updatestmt2 = conn.prepareStatement(updatePublicationSql);

                        updatestmt1.setString(1, issue.getTopic());
                        updatestmt1.setString(2, issue.getTitle());
                        updatestmt1.setString(3, issue.getPublicationDate());
                        updatestmt1.setString(4, issue.getPeriodicity());
                        updatestmt1.setInt(5, issue.getPublicationID());

                        updatestmt2.setString(1, publication.getTopic());
                        updatestmt2.setString(2, publication.getTitle());
                        updatestmt2.setString(3, publication.getPublicationDate());
                        updatestmt2.setInt(4, publication.getPublicationID());

                        int row1 = updatestmt1.executeUpdate();
                        int row2 = updatestmt2.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function deletes Book or Issues using the deletePublicationSql command declared above. Since we have a
    cascade delete setup in Publications table, any changes on delete will be reflected on Books and Issues. This way,
    we directly make the delete operation on the Publication table, as the primary key for all three tables are
    publication_id
    The function utilizes the DBHelper file to create and close DB connections.
     */
    public static void deleteBookOrIssue() {
        System.out.println("\nDelete Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Delete Book");
            System.out.println("2. Delete Issue");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            int id;
            switch (choice) {
                case 1:
                case 2:
                    System.out.println("Deletion in Progress...\n");
                    System.out.println("Enter Publication ID: \n");
                    id = scanner.nextInt();

                    try {
                        Connection conn = DBHelper.getConnection();
                        Statement deleteStmt = conn.createStatement();
                        deleteStmt.executeQuery(String.format(deletePublicationSql, id));
                        DBHelper.close(conn);
                        System.out.println("Deleted Successfully...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function handles creation of a Chapter or an Article. It uses the insertChapterSql
    and insertArticleSql commands declared above, and utilizes the DBHelper file to create and close DB connections.
    */
    public static void createChapterOrArticle() {
        System.out.println("\nCreate Chapter or Article...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Create Chapter");
            System.out.println("2. Create Article");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("\n Welcome to the WolfPub. Please enter the following details.");
                    System.out.println("\nPublication ID: ");
                    int pubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Chapter ID: ");
                    int chapId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Chapter Text: ");
                    String chapText = scanner.nextLine();

                    Chapter chapter = new Chapter(pubId, chapId, chapText);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertChapterSql);
                        insertstmt.setInt(1, chapter.getPublicationID());
                        insertstmt.setInt(2, chapter.getChapterID());
                        insertstmt.setString(3, chapter.getChapterText());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("\n Welcome to the WolfPub. Please enter the following details.");
                    System.out.println("Topic: ");
                    String articleTopic = scanner.nextLine();
                    System.out.println("Content: ");
                    String articleContent = scanner.nextLine();

                    Article article = new Article(articleTopic, articleContent);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertArticleSql);
                        insertstmt.setString(1, article.getTopic());
                        insertstmt.setString(2, article.getContent());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function updates Chapter or Article using the updateChapterSql and updateArticleSql commands declared
    above. The function utilizes the DBHelper file to create and close DB connections.
     */
    public static void updateChapterOrArticle() {
        System.out.println("\nUpdate Chapter or Article...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Update Chapter");
            System.out.println("2. Update Article");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            int pid, cid, aid;

            switch (choice) {
                case 1:
                    System.out.println("Updating Chapter...\n");
                    System.out.println("Input Publication Id of the Chapter: ");
                    pid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Input Chapter Id of the Chapter: ");
                    cid = scanner.nextInt();
                    ;
                    scanner.nextLine();

                    try {
                        Connection conn = DBHelper.getConnection();
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery(String.format(selectChapterSql, pid, cid));
                        ArrayList<String[]> rsList = rsToList(rs);
                        String[] attributes = rsList.get(1);
                        Chapter chapter = new Chapter(pid, cid, attributes[2]);
                        System.out.println("Enter new Chapter Text");
                        String newChapterText = scanner.nextLine();
                        chapter.setChapterText(newChapterText);

                        PreparedStatement updatestmt = conn.prepareStatement(updateChapterSql);
                        updatestmt.setString(1, chapter.getChapterText());
                        updatestmt.setInt(2, chapter.getPublicationID());
                        updatestmt.setInt(3, chapter.getChapterID());
                        int row = updatestmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Updating Article...\n");
                    System.out.println("Input Article Id of the Chapter: ");
                    aid = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Connection conn = DBHelper.getConnection();
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery(String.format(selectArticleSql, aid));
                        ArrayList<String[]> rsList = rsToList(rs);
                        String[] attributes = rsList.get(1);
                        Article article = new Article(aid, attributes[1], attributes[2]);

                        int updatechoice = 1;
                        while (updatechoice != 3) {
                            System.out.println("Choose the attribute you'd like to update");
                            System.out.println("1. Topic");
                            System.out.println("2. Content");
                            System.out.println("3: Finish Update");
                            updatechoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (updatechoice) {
                                case 1:
                                    System.out.println("Enter new Article Topic");
                                    String newArticleTopic = scanner.nextLine();
                                    article.setTopic(newArticleTopic);
                                    break;
                                case 2:
                                    System.out.println("Enter new Article Content");
                                    String newArticleContent = scanner.nextLine();
                                    article.setContent(newArticleContent);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Invalid option entered! Please enter a valid option.\n");
                            }
                        }
                        PreparedStatement updatestmt = conn.prepareStatement(updateArticleSql);
                        updatestmt.setString(1, article.getTopic());
                        updatestmt.setString(2, article.getContent());
                        updatestmt.setInt(3, article.getArticleID());
                        int row = updatestmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    The function allows insertion of Payment Data for staffs. It uses insertPaymentsSql command to execute the process.
    Since Editors and Authors are staffs by nature, we use staff_id as primary key to identify them and therefore use
    it to add any new payments to the table.
    The function utilizes the DBHelper file to create and close DB connections.
     */

    public static void insertPaymentEditorAuthor() {
        System.out.println("\nEnter Payment for Staff(Editor/Author). Please enter the following payment details.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nStaff ID: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Staff's Salary: ");
        Float staffSalary = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Date Claimed (YYYY-MM-DD): ");
        String dateClaimed = scanner.nextLine();

        Payments payments = new Payments(staffId, staffSalary, dateClaimed);
        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement insertstmt = conn.prepareStatement(insertPaymentsSql);
            insertstmt.setInt(1, payments.getStaffID());
            insertstmt.setFloat(2, payments.getSalary());
            insertstmt.setString(3, payments.getDateClaimed());
            int row = insertstmt.executeUpdate();
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    The function allows users to track the payments claimed by the staffs. It uses selectPaymentAddresseeSql to execute
    the needful. Using the staff_id, we check the payments table joined with staffs table to see which staff claimed
    the payment and also the number of claims made by that staff.
    The function utilizes the DBHelper file to create and close DB connections.
     */

    public static void trackPaymentClaims() {
        System.out.println("\nTrack Payment Claimed by Addressee...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        System.out.println("Enter Staff ID: \n");
        int staffId = scanner.nextInt();
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(String.format(selectPaymentAddresseeSql, staffId));
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    This function helps user to link an Author to a Publication(Book/Chapter/Article). It uses the insertAuthorToBook,
    insertAuthorToArticle and insertAuthorToChapter commands declared above.
    The function utilizes the DBHelper file to create and close DB connections.
     */

    public static void enterAuthorForPublications() {
        System.out.println("\nEnter Authors for Publications...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:while (choice != 4)
        {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Enter Author for Book.");
            System.out.println("2. Enter Author for Article.");
            System.out.println("3. Enter Author for Chapters.");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            int pubId,staffId;

            switch (choice) {
                case 1:
                    System.out.println("Adding Author to Book.");
                    System.out.println("Enter Book's Publication ID:");
                    pubId = scanner.nextInt();
                    System.out.println("Enter Staff ID:");
                    staffId = scanner.nextInt();

                    WritesBooks writer1 = new WritesBooks(staffId,pubId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToBook);
                        insertstmt.setInt(1,writer1.getStaffID());
                        insertstmt.setInt(2,writer1.getPublicationID());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Adding Author to Articles.");
                    System.out.println("Enter Article ID:");
                    int artId = scanner.nextInt();
                    System.out.println("Enter Staff ID:");
                    staffId = scanner.nextInt();

                    WritesArticles writer2 = new WritesArticles(staffId,artId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToArticles);
                        insertstmt.setInt(1,writer2.getStaffID());
                        insertstmt.setInt(2,writer2.getArticleID());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Adding Author to Chapters.");
                    System.out.println("Enter Book's Publication ID:");
                    pubId = scanner.nextInt();
                    System.out.println("Enter Book's Chapter ID:");
                    int chapId = scanner.nextInt();
                    System.out.println("Enter Staff ID:");
                    staffId = scanner.nextInt();

                    WritesChapters writer3 = new WritesChapters(staffId,pubId,chapId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToChapters);
                        insertstmt.setInt(1,writer3.getStaffID());
                        insertstmt.setInt(2,writer3.getPublicationID());
                        insertstmt.setInt(3,writer3.getChapterID());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
    }

    /*
    This function uses the displayString sent from displayBookOrIssue() function and based on the criteria, it
    executes and displays the result.
    The function utilizes the DBHelper file to create and close DB connections.
     */

    public static void displayFunction(String displayString)
    {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(displayString);
            ArrayList<String[]> rsList = rsToList(rs);
            printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
