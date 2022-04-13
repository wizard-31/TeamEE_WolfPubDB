package main.java.wolfpub.dbobject;

import java.util.Date;

public class Issue
{
    private Integer Publication_ID;
    private String Publication_Type;
    private String Topic;
    private String Title;
    private String Publication_Date;
    private String Periodicity;

    public Issue(Integer publication_ID, String publication_Type, String topic, String title, String publication_Date, String periodicity)
    {
        this.Publication_ID = publication_ID;
        this.Publication_Type = publication_Type;
        this.Topic = topic;
        this.Title = title;
        this.Publication_Date = publication_Date;
        this.Periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "Publication_ID=" + Publication_ID +
                ", Publication_Type='" + Publication_Type + '\'' +
                ", Topic='" + Topic + '\'' +
                ", Title='" + Title + '\'' +
                ", Publication_Date='" + Publication_Date + '\'' +
                ", Periodicity='" + Periodicity + '\'' +
                '}';
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

    public String getPeriodicity() { return Periodicity; }
    public void setPeriodicity(String periodicity) { this.Periodicity = periodicity; }
}
