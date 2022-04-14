package main.java.wolfpub.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import main.java.wolfpub.utils.*;
import main.java.wolfpub.dbobject.Publication;
import main.java.wolfpub.dbobject.Chapter;
import main.java.wolfpub.dbobject.Article;
import main.java.wolfpub.dbobject.EditedBy;
import main.java.wolfpub.dbobject.Contains;
public class PublicationDAO {

    public static void saveData(Publication publication) {
        try {
            String query = "Insert into publication" + publication.getMeta() + " values" + publication.toString();
            DBHelper.executeUpdate(query);

            System.out.println("Publication Added!");

            //Publication publciationDisplay= getPublicationByTitle(publication.getTitle());
            //publciationDisplay.display();

        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }


    public static void show() {


        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select * from publication;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Publication loadById(Integer id) {
        try {
            String query = "Select * from publication where publication_id = '" + id + "'";
            List < Object[] > rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublicationID((Integer) o[0]);
            publication.setPublicationType((String) o[1]);
            publication.setTopic((String) o[2]);
            publication.setTitle((String) o[3]);
            publication.setPublicationDate(o[4].toString());
            return publication;
        } catch (SQLException e) {
            System.out.println("Unable to load Publication");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }

    public static String getPublicationByTitle(String title) {

        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("select * from publication where title like '%" + title + "%'");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            if (rsList != null)
            	PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);
            if (rsList != null) {
                return "found";
            } else {

                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Publication updatePublication(String field, String value, Integer id, String type) throws SQLException {
        String updateQuery;
        String updateQuery1;
        //Converting String to Date
        Connection conn = DBHelper.getConnection();
        Statement Stmt = conn.createStatement();
        // start transaction 
        conn.setAutoCommit(false);


        if ("Date".equals(field)) {

            //ResultSet rs = selectStmt.executeQuery("UPDATE publication SET "+field+ "= '" +sqlDate + "' WHERE publication_id = '"+ id + "'");

            updateQuery = "UPDATE publication SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";

            if (type.equals("Book"))
                updateQuery1 = "UPDATE books SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";


            else
                updateQuery1 = "UPDATE issue SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";

        } else {
            updateQuery = "UPDATE publication SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";
            if (type.equals("Book"))
                updateQuery1 = "UPDATE books SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";

            else
                updateQuery1 = "UPDATE issue SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";


        }
        // onemore query = books or issues

        try {
            //DBHelper.executeUpdate(updateQuery);
            //DBHelper.executeUpdate(updateQuery1);


            Stmt.executeQuery(updateQuery);
            Stmt.executeQuery(updateQuery1);


            // execute the other query for books or issues
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conn.commit();
        DBHelper.close(conn);
        // commit tranasction

        String query = "select * from publication where publication_id='" + id + "'";
        try {
            List < Object[] > rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublicationID((Integer) o[0]);
            publication.setPublicationType((String) o[1]);
            publication.setTopic((String) o[2]);
            publication.setTitle((String) o[3]);
            publication.setPublicationDate(o[4].toString());
            return publication;
        } catch (SQLException e) {
            System.out.println("Unable to fetch Publication id");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }



    public static void insertChapter(Chapter chapter) {
        try {
            String query = "Insert into chapter" + chapter.getMeta() + " values" + chapter.toString();
            DBHelper.executeUpdate(query);

            System.out.println("Chapter Added!");
        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }





    public static Integer insertArticle(Article article) {
        Integer article_id = null;
        try {
            String query = "Insert into article" + article.getMeta() + " values" + article.toString();
            DBHelper.executeUpdate(query);

            String query1 = "Select article_id from article where topic = '" + article.getTopic() + "' and content='" + article.getContent() + "'";
            System.out.println("Article Added!");

            List < Object[] > rs = DBHelper.executeQueryUpdated(query1);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);

            article_id = (Integer) o[0];



        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
        return article_id;
    }


    public static void addPublicationArticle(Contains contains) {
        try {
            String query = "Insert into contains" + contains.getMeta() + " values" + contains.toString();
            DBHelper.executeUpdate(query);

            System.out.println("Publication  Added with Article !");
        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }


    public static void deleteArticle(Integer articleId) {
        try {


            String query = "Delete from article where  article_id= " + articleId;
            DBHelper.executeUpdate(query);

            System.out.println("Article Deleted!");
        } catch (SQLException e) {
            System.out.println("Unable to Delete Article!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }

    public static void deleteChapter(Integer publicationId, Integer chapterId) {
        try {
            String query = "Delete from chapter where  publication_id= '" + publicationId + "' and chapter_id= '" + chapterId + "'";
            DBHelper.executeUpdate(query);


            System.out.println("Chapter Deleted!");
        } catch (SQLException e) {
            System.out.println("Unable to Delete Chapter!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }


    public static void assignEditorPublication(EditedBy editedBy) {
        try {
            String query = "Insert into edited_by" + EditedBy.getMeta() + " values" + editedBy.toString();
            DBHelper.executeUpdate(query);

            System.out.println("Editor Added to the Publication!");
            editedBy.display();
        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }

    private Integer publication_id;
    private String publication_type;
    private String topic;
    private String title;



    public static Boolean loadByEditorId(Integer id) {

        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("Select * from edited_by where staff_id = '" + id + "'");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



    public static void showEditor() {


        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select staff_id,name from editor;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void showArticle() {


        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select * from article;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public static void showChapter() {


        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select * from chapter;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void showPublication() {


        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select publication_id,title from publication;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            PrintUtil.printResultSet(rsList);

            DBHelper.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }





}