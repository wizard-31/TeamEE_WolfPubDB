package main.java.wolfpub.dbobject;

import java.util.Date;

public class Books
{
    private Integer publication_Id;
    private String publication_Type;
    private String topic;
    private String title;
    private Date publication_Date;
    private String isbn;
    private String edition;

    public Books(Integer publication_Id, String publication_Type, String topic, String title, Date publication_Date, String isbn, String edition)
    {
        this.publication_Id = publication_Id;
        this.publication_Type = publication_Type;
        this.topic = topic;
        this.title = title;
        this.publication_Date = publication_Date;
        this.isbn = isbn;
        this.edition = edition;
    }

    //Initializing Getters and Setters
    public Integer getPublication_Id() { return publication_Id; }
    public void setPublication_Id(Integer publication_Id) { this.publication_Id = publication_Id; }

    public String getPublication_Type() { return publication_Type; }
    public void setPublication_Type(String publication_Type) { this.publication_Type = publication_Type; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getPublication_Date() { return publication_Date; }
    public void setPublication_Date(Date publication_Date) { this.publication_Date = publication_Date; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }
}