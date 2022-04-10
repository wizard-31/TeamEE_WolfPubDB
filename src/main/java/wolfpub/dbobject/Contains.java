package main.java.wolfpub.dbobject;

public class Contains
{
    private Integer publication_Id;
    private Integer article_Id;

    public Contains(Integer publication_Id, Integer article_Id)
    {
        this.publication_Id = publication_Id;
        this.article_Id = article_Id;
    }

    //Initializing Getters and Setters
    public Integer getPublication_Id() { return publication_Id; }
    public void setPublication_Id(Integer publication_Id) { this.publication_Id = publication_Id; }

    public Integer getArticle_Id() { return article_Id; }
    public void setArticle_Id(Integer article_Id) { this.article_Id = article_Id; }
    
    public void display() {
        System.out.println("Article and Publication Details");
        System.out.println("Publication Id: " + publication_Id);
        System.out.println("Article Id: " + article_Id);
      
     
        return;
        
    }

    public String getMeta() {
        return "( publication_Id, article_Id)";
    }

    public String toString() {
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
}