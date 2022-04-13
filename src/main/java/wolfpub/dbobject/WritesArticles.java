package main.java.wolfpub.dbobject;

public class WritesArticles
{
    private Integer staffID;
    private Integer articleID;

    public WritesArticles(Integer staffID, Integer articleID)
    {
        this.staffID = staffID;
        this.articleID = articleID;
    }

    //Initializing Getters and Setters
    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public Integer getArticleID() { return articleID; }
    public void setArticleID(Integer articleID) { this.articleID = articleID; }
}
