package main.java.wolfpub.dbobject;

public class Issue
{
    private Integer publicationID;
    private String publicationType;
    private String topic;
    private String title;
    private String publicationDate;
    private String periodicity;

    public Issue(Integer publicationID, String publicationType, String topic, String title, String publicationDate, String periodicity)
    {
        this.publicationID = publicationID;
        this.publicationType = publicationType;
        this.topic = topic;
        this.title = title;
        this.publicationDate = publicationDate;
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "Publication_ID=" + publicationID +
                ", Publication_Type='" + publicationType + '\'' +
                ", Topic='" + topic + '\'' +
                ", Title='" + title + '\'' +
                ", Publication_Date='" + publicationDate + '\'' +
                ", Periodicity='" + periodicity + '\'' +
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

    public String getPeriodicity() { return periodicity; }
    public void setPeriodicity(String periodicity) { this.periodicity = periodicity; }
}