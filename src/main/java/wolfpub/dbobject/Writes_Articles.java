package main.java.wolfpub.dbobject;

public class Writes_Articles
{
    private Integer Staff_ID;
    private Integer Article_ID;

    public Writes_Articles(Integer staff_ID, Integer article_ID)
    {
        this.Staff_ID = staff_ID;
        this.Article_ID = article_ID;
    }

    //Initializing Getters and Setters
    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public Integer getArticle_ID() { return Article_ID; }
    public void setArticle_ID(Integer article_ID) { this.Article_ID = article_ID; }
}
