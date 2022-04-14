package main.java.wolfpub.dao;



import main.java.wolfpub.*;
import main.java.wolfpub.dbobject.Publication;
import main.java.wolfpub.dbobject.EditedBy;
import main.java.wolfpub.dbobject.Chapter;
import main.java.wolfpub.dbobject.Article;
import main.java.wolfpub.dbobject.Contains;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PublicationHelper {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        Publication publication = getPublicationDetails();
        PublicationDAO.saveData(publication);

        //WolfPubMain.main(null);
        return;


    }

    public static void show(Integer id) {

        Publication publication = PublicationDAO.loadById(id);
        if (publication != null) {
            publication.display();
        } else {
            System.out.println("Publication not found!");
        }
        return;

    }



    public static void search() {
        System.out.println("1.Enter the Publication Id ");

        Integer id = scanner.nextInt();
        Publication publication = PublicationDAO.loadById(id);
       
        if (publication !=null) {
        	  String publciation_type = publication.getPublicationType();
            publication.display();
            System.out.println(publciation_type);
            PublicationHelper.update(id, publciation_type);


        } else
            System.out.println("Publication Not Found");

        return;

    }

    public static void update(Integer id, String type) {
        System.out.println("1.Select the field which need to be changed");
        System.out.println(" 1. Topic  2. Title  3.Date");

        Integer option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {

            case 1:
                System.out.println("1.Enter the Topic");
                String topicValue = scanner.nextLine();
                String topic = "topic";

                try {
                    PublicationDAO.updatePublication(topic, topicValue, id, type);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             
                break;

            case 2:
                System.out.println("1.Enter the Title");
                String titleValue = scanner.nextLine();
                String title = "title";
                try {
                    PublicationDAO.updatePublication(title, titleValue, id, type);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             
                break;
            case 3:
                System.out.println("1.Enter the Date");
                String dateValue = scanner.nextLine();
                String date = "publication_date";

                try {
                    PublicationDAO.updatePublication(date, dateValue, id, type);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        
                break;
        }

        System.out.println("1.Do you need to change any other field 2. Main menu");
        System.out.println("Enter an option");

        Integer optionAgain = scanner.nextInt();
        scanner.nextLine();
        switch (optionAgain) {
            case 1:
                update(id, type);
                break;
            case 2:
                //WolfPubMain.main(null);
                return;


        }

        return;

    }


    public static void assign() {


        PublicationDAO.showEditor();
        PublicationDAO.showPublication();
        System.out.println("1. Enter Publication id");
        Integer publication_id = scanner.nextInt();
        System.out.println("1. Enter Editor id");
        Integer editor_id = scanner.nextInt();
        scanner.nextLine();
        EditedBy editedBy = new EditedBy(publication_id, editor_id);
        PublicationDAO.assignEditorPublication(editedBy);


    }

    public static void view() {

        System.out.println(" Enter Staff Id or Editor id ");
        Integer editorId = scanner.nextInt();

        PublicationDAO.loadByEditorId((Integer) editorId);
        return;




    }






    public static void tableofcontents() {


        System.out.println("1. Add Chapter 2. Add Article  3. Link Publication to Article  4. Delete Article  5. Delete Chapter 6.Show Article 7.Show Chapter");
        System.out.println("Enter an Option");
        Integer option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                addChapter();
                break;
            case 2:
                addArticle();
                break;
            case 3:
                linkPublicationArticle();

                break;
            case 4:
                deleteArticle();
                break;
            case 5:
                deleteChapter();
                break;
            case 6:
                PublicationDAO.showArticle();
                break;
            case 7:
                PublicationDAO.showChapter();
                break;



        }

    }



    public static void addChapter() {
        Chapter chapter = getChapterDetails();
        PublicationDAO.insertChapter(chapter);


    }


    public static void addArticle() {
        Article article = getArticleDetails();
        Integer article_id = PublicationDAO.insertArticle(article);
        System.out.println("1. Do you also want to insert into publication \n2. Go Back");
        System.out.println("Enter an Option");
        Integer value = scanner.nextInt();
        switch (value) {
            case 1:


                System.out.println(article_id);
                System.out.println("1. Enter the Publication Id ");
                Integer publication_id = scanner.nextInt();
                Contains contains = new Contains(publication_id, article_id);
                PublicationDAO.addPublicationArticle(contains);
                break;
            case 2:
                //WolfPubMain.main(null);
                return;

        }


        return;

    }


    public static void linkPublicationArticle() {
        System.out.println("1. Enter the Publication Id ");
        Integer publication_id = scanner.nextInt();
        System.out.println("1. Enter the Article Id ");
        Integer articleValueId = scanner.nextInt();
        Contains contains = new Contains(publication_id, articleValueId);
        PublicationDAO.addPublicationArticle(contains);
        contains.display();
    }



    public static void deleteArticle() {

        System.out.println("1. Enter the Article Id ");
        Integer articleId = scanner.nextInt();


        PublicationDAO.deleteArticle(articleId);




    }


    public static void deleteChapter() {

        System.out.println("1. Enter the Publication Id ");
        Integer publciationId = scanner.nextInt();
        System.out.println("1. Enter the Chapter Id ");
        Integer chapterId = scanner.nextInt();


        PublicationDAO.deleteChapter(publciationId, chapterId);


    }
    public static Date readDate(Scanner scanner, String format) throws ParseException {
        return (Date) new SimpleDateFormat(format).parse(scanner.nextLine());
    }

    public static Date StringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        System.out.println("Date object value: " + date);
        return date;
    }
    private static Publication getPublicationDetails() {
        Publication publication = new Publication();
        System.out.println("Enter Publication Type");
        String type = scanner.nextLine();
        publication.setPublicationType(type);
        System.out.println("Enter Publication Topic");
        String topic = scanner.nextLine();
        publication.setTopic(topic);
        System.out.println("Enter Publication Title");
        String title = scanner.nextLine();
        publication.setTitle(title);
        System.out.println("Enter Publication Date");


        String dateValue = scanner.nextLine();
        //Converting String to Date
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate = null;
//        try {
//            myDate = formatter.parse(dateValue);
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        publication.setPublicationDate(dateValue);

        return publication;
    }


    public static Chapter getChapterDetails() {
        Chapter chapter = new Chapter();
       
        System.out.println("Enter Publciation Id");
        Integer publicationId = scanner.nextInt();
        chapter.setPublicationID(publicationId);
        System.out.println("Enter Chapter Id");
        Integer chapterId = scanner.nextInt();

        chapter.setChapterID(chapterId);
        scanner.nextLine();
        System.out.println("Enter Chapter Text");

        String chapterText = scanner.nextLine();
        chapter.setChapterText(chapterText);
        return chapter;
    }

    public static Article getArticleDetails() {
        Article article = new Article();
        //scanner.nextLine();
        System.out.println("Enter Topic");
        String topic = scanner.nextLine();
        article.setTopic(topic);
        System.out.println("Enter Content");

        String content = scanner.nextLine();
        article.setContent(content);
        return article;
    }







}