package main.java.wolfpub.dbobject;

public class WritesBooks
{
    private Integer staffID;
    private Integer publicationID;

    public WritesBooks(Integer staffID, Integer publicationID)
    {
        this.staffID = staffID;
        this.publicationID = publicationID;
    }

    //Initializing Getters and Setters
    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }
}
