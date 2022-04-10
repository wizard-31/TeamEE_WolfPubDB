package main.java.wolfpub.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
            Publication publciationDisplay= getPublicationByTitle(publication.getTitle());
            publciationDisplay.display();
            
        } catch (SQLException e) {
            System.out.println("Unable to add Customer!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
    
    

    public static void insertChapter(Chapter chapter) {
        try {
            String query = "Insert into chapter" + chapter.getMeta() + " values" + chapter.toString();
            DBHelper.executeUpdate(query);
           
            System.out.println("Chapter Added!");
        } catch (SQLException e) {
            System.out.println("Unable to add Customer!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
    
    
    public static void deleteArticle(Integer articleId) {
        try {
        	
        	
            String query = "Delete from article where  article_id= " + articleId  ;
            DBHelper.executeUpdate(query);
           
            System.out.println("Article Deleted!");
        } catch (SQLException e) {
            System.out.println("Unable to Delete Article!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
    
    public static void deleteChapter(Integer publicationId, Integer chapterId) {
        try {
        	 String query = "Delete from chapter where  publication_id= '" + publicationId + "' and chapter_id= '" + chapterId +"'" ;
             DBHelper.executeUpdate(query);
           
           
            System.out.println("Chapter Deleted!");
        } catch (SQLException e) {
            System.out.println("Unable to Delete Chapter!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
    
    
    public static Integer insertArticle(Article article) {
    	 Integer article_id = null;
        try {
            String query = "Insert into article" + article.getMeta() + " values" + article.toString();
            DBHelper.executeUpdate(query);
            
            String query1 = "Select article_id from article where topic = '" + article.getTopic() + "' and content='"+article.getContent()+"'";
            System.out.println("Article Added!");
            
            List<Object[]> rs = DBHelper.executeQueryUpdated(query1);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            
             article_id = (Integer)o[0];
       
            
           
           
        } catch (SQLException e) {
            System.out.println("Unable to add Customer!");
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
            System.out.println("Unable to add Customer!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
    
    private Integer publication_id;
	private String publication_type;
	private String topic;
	private String title;
	private Date publication_date;
	
	
	

    public static Publication loadByEditorId(Integer id) {
        try {
            String query = "Select * from publication natural join edited_by where staff_id = '" + id + "'";
            List<Object[]> rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublication_id((Integer)o[0]);
            publication.setPublication_type((String)o[1]);
            publication.setTopic((String)o[2]);
            publication.setTitle((String)o[3]);
            publication.setPublication_date((Date)o[4]);
            return publication;
        } catch (SQLException e) {
            System.out.println("Unable to load Publication");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }
    
    public static Publication loadById(Integer id) {
        try {
            String query = "Select * from publication where publication_id = '" + id + "'";
            List<Object[]> rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublication_id((Integer)o[0]);
            publication.setPublication_type((String)o[1]);
            publication.setTopic((String)o[2]);
            publication.setTitle((String)o[3]);
            publication.setPublication_date((Date)o[4]);
            return publication;
        } catch (SQLException e) {
            System.out.println("Unable to load Publication");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }
    
    public static Publication getPublicationByTitle(String title){
        String query="select * from publication where title ='"+title+"'";
        try {
            List<Object[]> rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublication_id((Integer)o[0]);
            publication.setPublication_type((String)o[1]);
            publication.setTopic((String)o[2]);
            publication.setTitle((String)o[3]);
            publication.setPublication_date((Date)o[4]);
            return publication;
        } 
        
        catch (SQLException e) {
            System.out.println("Unable to fetch Publication id");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }
    public static void assignEditorPublication(EditedBy editedBy) {
        try {
            String query = "Insert into edited_by" + EditedBy.getMeta() + " values" + editedBy.toString();
            DBHelper.executeUpdate(query);
           
            System.out.println("Editor Added to the Publication!");
            editedBy.display();
        } catch (SQLException e) {
            System.out.println("Unable to add Customer!");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
        }
    }
	
    
    public static Publication updatePublciation(String field,String value, Integer id){
    	String updateQuery;
    	   //Converting String to Date
    	if(field=="Date") {

    	
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
		try {
			myDate = formatter.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
         updateQuery = "UPDATE publication SET "+field+ "= '" +sqlDate + "' WHERE publication_id = '"+ id + "'";
    	}
    	else
    	  updateQuery = "UPDATE publication SET "+field+ "= '" +value + "' WHERE publication_id = '"+ id + "'";
    	
      
         try {
			DBHelper.executeUpdate(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        String query="select * from publication where publication_id='"+id+"'";
        try {
            List<Object[]> rs = DBHelper.executeQueryUpdated(query);
            if (rs.isEmpty()) {
                return null;
            }
            Object[] o = rs.get(0);
            Publication publication = new Publication();
            publication.setPublication_id((Integer)o[0]);
            publication.setPublication_type((String)o[1]);
            publication.setTopic((String)o[2]);
            publication.setTitle((String)o[3]);
            publication.setPublication_date((Date)o[4]);
            return publication;
        } 
        catch (SQLException e) {
            System.out.println("Unable to fetch Publication id");
            System.out.println("Caught SQLException " + e.getErrorCode() + "/" + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }
}
