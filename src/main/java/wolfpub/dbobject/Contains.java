package main.java.wolfpub.dbobject;

public class Contains
{   
    private Integer Publication_ID;
    private Integer Article_ID;

    public Contains(Integer publication_ID, Integer article_ID)
    {
        this.Publication_ID = publication_ID;
        this.Article_ID = article_ID;
    }
  
    public void display() 
    {
        System.out.println("Article and Publication Details");
        System.out.println("Publication Id: " + publication_Id);
        System.out.println("Article Id: " + article_Id);
        return;
    }

    public String getMeta() {
        return "( publication_Id, article_Id)";
    }

    public String toString() 
    {
        String res = "(";
      
        res = res + "'";
        res = res + publication_Id;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + article_Id;
        res = res + "'";
        res = res + ")";
        return res;
    
    }
  
    //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getArticle_ID() { return Article_ID; }
    public void setArticle_ID(Integer article_ID) { this.Article_ID = article_ID; }
}