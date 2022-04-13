package main.java.wolfpub.dbobject;
import java.util.Date;

public class Publication
{
    private Integer Publication_ID;
    private String Publication_Type;
    private String Topic;
    private String Title;
    private String Publication_Date;

    public Publication(Integer publication_ID, String publication_Type, String topic, String title, String publication_Date)
    {
        this.Publication_ID = publication_ID;
        this.Publication_Type = publication_Type;
        this.Topic = topic;
        this.Title = title;
        this.Publication_Date = publication_Date;
    }

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public String getPublication_Type() { return Publication_Type; }
    public void setPublication_Type(String publication_Type) { this.Publication_Type = publication_Type; }

    public String getTopic() { return Topic; }
    public void setTopic(String topic) { this.Topic = topic; }

    public String getTitle() { return Title; }
    public void setTitle(String title) { this.Title = title; }

    public String getPublication_Date() { return Publication_Date; }
    public void setPublication_Date(String publication_Date) { this.Publication_Date = publication_Date; }
    
    public void display() {
        System.out.println("Pulication Details");
        System.out.println("Id: " + Publication_ID);
        System.out.println("Type: " + Publication_Type);
        System.out.println("Topic: " + Topic);
        System.out.println("Title: " + Title);
        System.out.println("Publication Date: " + Publication_Date);
        return;
        
    }

    public String getMeta() {
        return "( publication_type, topic, title, publication_date)";
    }

    @Override
    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + Publication_Type;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Topic;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Title;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Publication_Date;
        res = res + "'";
        res = res + ")";
        return res;
    }
}