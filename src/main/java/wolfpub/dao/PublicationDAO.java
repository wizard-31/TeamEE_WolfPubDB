package main.java.wolfpub.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

/*
The Publication helper class contains all the code for the execution of all the operations in the Reports Section of the narrative. This is used in the Reports class in the menu directory. Please see below for information about each function in the class.
 */
public class PublicationDAO {

	//This function is to save the publication data
    public static void saveData(Publication publication) {
        try {
            String query = "Insert into publication" + publication.getMeta() + " values" + publication.toString();
            DBHelper.executeUpdate(query);
            System.out.println("Publication Added!");
        } catch (SQLException e) {
            System.out.println("Unable to add!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
  //This function is to display all the publication 
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
    //This function is to get the publication by publication id 
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
    //This function is to get the publication by publication title 
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
    //This function is to update the publication by publication id 
    public static void updatePublication(String field, String value, Integer id, String type) throws SQLException {
        String updateQuery;
        String updateQuery1;
        Connection conn = DBHelper.getConnection();
        try {
        Statement Stmt = conn.createStatement();
        // start transaction 
        
       
        conn.setAutoCommit(false);
        
            updateQuery = "UPDATE publication SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";
            if (type.equals("Book"))
                updateQuery1 = "UPDATE books SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";
            else
                updateQuery1 = "UPDATE issue SET " + field + "= '" + value + "' WHERE publication_id = '" + id + "'";
        
            int value1=Stmt.executeUpdate(updateQuery);
            
            int value2= Stmt.executeUpdate(updateQuery1);

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
        // commit transaction
       
    }
    //This function is to insert into the chapter
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
    //This function is to insert into the Article
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
    //This function is to insert into the contains
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
    //This function is to delete the Article
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
    //This function is to delete the Chapter
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
    //This function is to into into editedby table
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
//  //This function is to select the Editor by staff id
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
//This function is to show the editor
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
  //This function is to show the article
    public static void showArticle() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select * from article;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            System.out.println("Scroll Right");
            PrintUtil.printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  //This function is to show the chapter
    public static void showChapter() {
        try {
            Connection conn = DBHelper.getConnection();
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery(" select * from chapter;");
            ArrayList < String[] > rsList = PrintUtil.rsToList(rs);
            System.out.println("Scroll Right");
            PrintUtil.printResultSet(rsList);
            DBHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  //This function is to show the publication
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