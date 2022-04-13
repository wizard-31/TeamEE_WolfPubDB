package main.java.wolfpub.dbobject;

public class WritesChapters
{
    private Integer staffID;
    private Integer publicationID;
    private Integer chapterID;

    public WritesChapters(Integer staffID, Integer publicationID, Integer chapterID)
    {
        this.staffID = staffID;
        this.publicationID = publicationID;
        this.chapterID = chapterID;
    }

    //Initializing Getters and Setters
    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }

    public Integer getChapterID() { return chapterID; }
    public void setChapterID(Integer chapterID) { this.chapterID = chapterID; }

}