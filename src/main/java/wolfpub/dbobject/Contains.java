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

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getArticle_ID() { return Article_ID; }
    public void setArticle_ID(Integer article_ID) { this.Article_ID = article_ID; }
}
