package main.java.wolfpub.dbobject;

import java.util.Date;

public class Issue
{
    private Integer publication_Id;
    private String publication_Type;
    private String topic;
    private String title;
    private Date publication_Date;
    private String periodicity;

    public Issue(Integer publication_ID, String publication_Type, String topic, String title, Date publication_Date, String periodicity)
    {
        this.publication_Id = publication_ID;
        this.publication_Type = publication_Type;
        this.topic = topic;
        this.title = title;
        this.publication_Date = publication_Date;
        this.periodicity = periodicity;
    }

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return publication_Id; }
    public void setPublication_ID(Integer publication_ID) { this.publication_Id = publication_ID; }

    public String getPublication_Type() { return publication_Type; }
    public void setPublication_Type(String publication_Type) { this.publication_Type = publication_Type; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getPublication_Date() { return publication_Date; }
    public void setPublication_Date(Date publication_Date) { this.publication_Date = publication_Date; }

    public String getPeriodicity() { return periodicity; }
    public void setPeriodicity(String periodicity) { this.periodicity = periodicity; }
}