package main.java.wolfpub.dbobject;

public class Publication
{
    private Integer publicationID;
    private String publicationType;
    private String topic;
    private String title;
    private String publicationDate;

    public Publication(Integer publicationID, String publicationType, String topic, String title, String publicationDate)
    {
        this.publicationID = publicationID;
        this.publicationType = publicationType;
        this.topic = topic;
        this.title = title;
        this.publicationDate = publicationDate;
    }


    //Initializing Getters and Setters
    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }
    public Publication() {
		// TODO Auto-generated constructor stub
	}


    public String getPublicationType() { return publicationType; }
    public void setPublicationType(String publicationType) { this.publicationType = publicationType; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublicationDate() { return publicationDate; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
    
    public void display() {
        System.out.println("Publication Details");
        System.out.println("Id: " + publicationID);
        System.out.println("Type: " + publicationType);
        System.out.println("Topic: " + topic);
        System.out.println("Title: " + title);
        System.out.println("Publication Date: " + publicationDate);
        return;
        
    }

    public String getMeta() {
        return "( publication_type, topic, title, publication_date)";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("('").append(publicationType).append("','").append(topic).append("','").append(title).append("','").append(publicationDate).append("')");
        return sb.toString();
    }

	
}