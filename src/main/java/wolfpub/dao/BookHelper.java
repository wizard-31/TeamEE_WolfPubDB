package main.java.wolfpub.dao;

import main.java.wolfpub.dbobject.*;

import static main.java.wolfpub.utils.PrintUtil.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookHelper {
    //Select Queries
    static String selectBookSql = "SELECT * FROM `books` WHERE `publication_id` = %d;";
    static String selectIssueSql = "SELECT * FROM `issue` WHERE `publication_id` = %d;";
    static String selectChapterSql = "SELECT * FROM `chapter` WHERE `publication_id` = %d AND `chapter_id` = %d;";
    static String selectArticleSql = "SELECT * FROM `article` WHERE `article_id` = %d;";
    static String selectPaymentAddresseeSql = "SELECT * FROM `payments` natural join `staff` WHERE `staff_id` = %d;";
    //Insert Queries
    static String insertBookSql = "INSERT INTO `books` (`publication_id`, `publication_type`, `topic`, `title`, `publication_date`,`ISBN`, `Edition`) VALUES (?,?,?,?,?,?,?);";
    static String insertIssueSql = "INSERT INTO `issue` (`publication_id`, `publication_type`, `topic`, `title`, `publication_date`,`periodicity`) VALUES (?,?,?,?,?,?);";
    static String insertArticleSql = "INSERT INTO `article` (`article_id`,`topic`,`content`) VALUES (?,?,?);";
    static String insertChapterSql = "INSERT INTO `chapter` (`publication_id`,`chapter_id`,`chapter_text`) VALUES (?,?,?);";
    static String insertPaymentsSql = "INSERT INTO `payments`(`staff_id`, `salary`,`date_claimed`) VALUES (?,?,?);";
    static String insertAuthorToBook = "INSERT INTO `writes_book` (`staff_id`,`publication_id`) VALUES (?,?);";
    static String insertAuthorToArticles = "INSERT INTO `writes_articles` (`staff_id`,`article_id`) VALUES (?,?);";
    static String insertAuthorToChapters = "INSERT INTO `writes_book` (`staff_id`,`publication_id`,`chapter_id`) VALUES (?,?,?);";
    //Update Queries
    static String updateBookSql = "UPDATE `books` SET `Edition` = ?, `topic` = ?, `title` = ?, `publication_date` = ?, `ISBN` = ? WHERE `publication_id` = ?;";
    static String updatePublicationSql = "UPDATE `publication` SET `topic` = ?, `title` = ?, `publication_date` = ? WHERE `publication_id` = ?;";
    static String updateIssueSql = "UPDATE `issue` SET `topic` = ?, `title` = ?, `publication_date` = ?, `periodicity` = ? WHERE `publication_id` = ?;";
    static String updateChapterSql = "UPDATE `chapter` SET `chapter_text` = ? WHERE `publication_id` = ? AND `chapter_id` = ?;";
    static String updateArticleSql = "UPDATE `article` SET `topic` = ?, `content` = ? WHERE `article_id`=?;";
    //Delete Queries
    static String deletePublicationSql = "DELETE FROM `publication` WHERE `publication_id` = %d;";

    public static void createBookOrIssue() {
        System.out.println("\nCreate Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
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
                    System.out.println("Publication Type: ");
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
                        insertstmt.setInt(1, book.getPublication_ID());
                        insertstmt.setString(2, book.getPublication_Type());
                        insertstmt.setString(3, book.getTopic());
                        insertstmt.setString(4, book.getTitle());
                        insertstmt.setString(5, book.getPublication_Date());
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
                    System.out.println("Publication's Periodicity : ");
                    String pubPeriod = scanner.nextLine();

                    Issue issue = new Issue(pubId, pubType, pubTopic, pubTitle, pubDate, pubPeriod);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertIssueSql);
                        insertstmt.setInt(1, issue.getPublication_ID());
                        insertstmt.setString(2, issue.getPublication_Type());
                        insertstmt.setString(3, issue.getTopic());
                        insertstmt.setString(4, issue.getTitle());
                        insertstmt.setString(5, issue.getPublication_Date());
                        insertstmt.setString(6, issue.getPeriodicity());
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
        scanner.close();
    }

    public static void displayBookOrIssue() {
        //TO-DO Sub-Menus
        System.out.println("\nDisplay Book or Issue...");
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        loop:
        while (choice != 3) {
            System.out.println("\nWelcome to the WolfPub Book/Periodic Publication Production! Please make your choice from the options below:\n");
            System.out.println("1. Display Book");
            System.out.println("2. Display Issue");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Displaying Book...");
                    try {
                        Connection conn = DBHelper.getConnection();
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery("Select * from books;");
                        ArrayList<String[]> rsList = rsToList(rs);
                        printResultSet(rsList);
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Displaying Issue...");
                    try {
                        Connection conn = DBHelper.getConnection();
                        Statement selectstmt = conn.createStatement();
                        ResultSet rs = selectstmt.executeQuery("Select * from issue;");
                        ArrayList<String[]> rsList = rsToList(rs);
                        printResultSet(rsList);
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
    scanner.close();
    }

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
                        //Connection conn = DBHelper.getConnection();
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
                                    book.setPublication_Date(newPubDate);
                                    publication.setPublication_Date(newPubDate);
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
                        updatestmt1.setString(4, book.getPublication_Date());
                        updatestmt1.setString(5, book.getISBN());
                        updatestmt1.setInt(6, book.getPublication_ID());
                        int row1 = updatestmt1.executeUpdate();
                        updatestmt2.setString(1, publication.getTopic());
                        updatestmt2.setString(2, publication.getTitle());
                        updatestmt2.setString(3, publication.getPublication_Date());
                        updatestmt2.setInt(4, publication.getPublication_ID());
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

                        //System.out.println("OP of Queries---" + row1 +" " +row2);
                    } catch (Exception e) {
                        //e.printStackTrace();
                        System.out.println("Transaction Failed. Doing a Rollback.....");
                        try{
                            System.err.print("Transaction rolled back.");
                            conn.rollback();
                        }
                        catch(SQLException e2){
                            //e2.printStackTrace();
                        }
                    }
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
                                    issue.setPublication_Date(newPubDate);
                                    publication.setPublication_Date(newPubDate);
                                    break;
                                case 4:
                                    System.out.println("Enter new Periodicity: ");
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
                        updatestmt1.setString(3, issue.getPublication_Date());
                        updatestmt1.setString(4, issue.getPeriodicity());
                        updatestmt1.setInt(5, issue.getPublication_ID());

                        updatestmt2.setString(1, publication.getTopic());
                        updatestmt2.setString(2, publication.getTitle());
                        updatestmt2.setString(3, publication.getPublication_Date());
                        updatestmt2.setInt(4, publication.getPublication_ID());

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
        scanner.close();
    }

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
                case 3:
                    break loop;
                default:
                    System.out.println("Invalid option entered! Please enter a valid option.\n");
            }
        }
        scanner.close();
    }

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
                        insertstmt.setInt(1, chapter.getPublication_ID());
                        insertstmt.setInt(2, chapter.getChapter_ID());
                        insertstmt.setString(3, chapter.getChapter_text());
                        int row = insertstmt.executeUpdate();
                        DBHelper.close(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("\n Welcome to the WolfPub. Please enter the following details.");
                    System.out.println("\nArticle ID: ");
                    int articleId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Topic: ");
                    String articleTopic = scanner.nextLine();
                    System.out.println("Content: ");
                    String articleContent = scanner.nextLine();

                    Article article = new Article(articleId, articleTopic, articleContent);
                    try {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertArticleSql);
                        insertstmt.setInt(1, article.getArticle_ID());
                        insertstmt.setString(2, article.getTopic());
                        insertstmt.setString(3, article.getContent());
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
        scanner.close();
    }

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
                        chapter.setChapter_text(newChapterText);

                        PreparedStatement updatestmt = conn.prepareStatement(updateChapterSql);
                        updatestmt.setString(1, chapter.getChapter_text());
                        updatestmt.setInt(2, chapter.getPublication_ID());
                        updatestmt.setInt(3, chapter.getChapter_ID());
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
                        updatestmt.setInt(3, article.getArticle_ID());
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
        scanner.close();
    }

    public static void insertPaymentEditorAuthor() {
        System.out.println("\nEnter Payment for Staff(Editor/Author). Please enter the following payment details.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nStaff ID: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Staff's Salary: ");
        Float staffSalary = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Date Claimed: ");
        String dateClaimed = scanner.nextLine();

        Payments payments = new Payments(staffId, staffSalary, dateClaimed);
        try {
            Connection conn = DBHelper.getConnection();
            PreparedStatement insertstmt = conn.prepareStatement(insertPaymentsSql);
            insertstmt.setInt(1, payments.getStaff_ID());
            insertstmt.setFloat(2, payments.getSalary());
            insertstmt.setString(3, payments.getDate_Claimed());
            int row = insertstmt.executeUpdate();
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

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
        scanner.close();
    }

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

                    Writes_Books writer1 = new Writes_Books(staffId,pubId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToBook);
                        insertstmt.setInt(1,writer1.getStaff_ID());
                        insertstmt.setInt(2,writer1.getPublication_ID());
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

                    Writes_Articles writer2 = new Writes_Articles(staffId,artId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToArticles);
                        insertstmt.setInt(1,writer2.getStaff_ID());
                        insertstmt.setInt(2,writer2.getArticle_ID());
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

                    Writes_Chapters writer3 = new Writes_Chapters(staffId,pubId,chapId);
                    try
                    {
                        Connection conn = DBHelper.getConnection();
                        PreparedStatement insertstmt = conn.prepareStatement(insertAuthorToChapters);
                        insertstmt.setInt(1,writer3.getStaff_ID());
                        insertstmt.setInt(2,writer3.getPublication_ID());
                        insertstmt.setInt(3,writer3.getChapter_ID());
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
        scanner.close();
    }

}