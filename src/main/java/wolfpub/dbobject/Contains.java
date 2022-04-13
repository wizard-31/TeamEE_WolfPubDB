package main.java.wolfpub.dbobject;

public class Contains
{   
    private Integer publicationID;
    private Integer articleID;

    public Contains(Integer publicationID, Integer articleID)
    {
        this.publicationID = publicationID;
        this.articleID = articleID;
    }
  
    public void display() 
    {
        System.out.println("Article and Publication Details");
        System.out.println("Publication Id: " + publicationID);
        System.out.println("Article Id: " + articleID);
        return;
    }

    public String getMeta() {
        return "( publication_Id, article_Id)";
    }

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("('").append(publicationID).append("','").append(articleID).append("')");
        return sb.toString();
    }
  
    //Initializing Getters and Setters
    public Integer getPublication_ID() { return publicationID; }
    public void setPublication_ID(Integer publication_ID) { this.publicationID = publication_ID; }

    public Integer getArticle_ID() { return articleID; }
    public void setArticle_ID(Integer article_ID) { this.articleID = article_ID; }
}