package main.java.wolfpub.dbobject;

public class Book
{
    private Integer publicationID;
    private String publicationType;
    private String topic;
    private String title;
    private String publicationDate;
    private String ISBN;
    private String edition;

    public Book(Integer publicationID, String publicationType, String topic, String title, String publicationDate, String ISBN, String edition)
    {
        this.publicationID = publicationID;
        this.publicationType = publicationType;
        this.topic = topic;
        this.title = title;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Publication_ID=" + publicationID +
                ", Publication_Type='" + publicationType + '\'' +
                ", Topic='" + topic + '\'' +
                ", Title='" + title + '\'' +
                ", Publication_Date='" + publicationDate + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Edition='" + edition + '\'' +
                '}';
    }

    //Initializing Getters and Setters
    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }

    public String getPublicationType() { return publicationType; }
    public void setPublicationType(String publicationType) { this.publicationType = publicationType; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublicationDate() { return publicationDate; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }
}
