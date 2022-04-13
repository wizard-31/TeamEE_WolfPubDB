package main.java.wolfpub.dbobject;

public class EditedBy
{
    private Integer publicationID;
    private Integer staffID;

    public EditedBy(Integer publication_ID, Integer staff_ID)
    {
        this.publicationID = publication_ID;
        this.staffID = staff_ID;
    }

    //Initializing Getters and Setters
    public Integer getPublicationID() { return publicationID; }
    public void setPublicationID(Integer publicationID) { this.publicationID = publicationID; }

    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public static String getMeta() {
        return "( publication_id, staff_id)";
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("('").append(publicationID).append("','").append(staffID).append("')");
        return sb.toString();
    }
    
    public void display() {
        System.out.println("Publication Id and Editor Id Details ");
        System.out.println("PublicationId: " + publicationID);
        System.out.println("Editor Id: " + staffID);
        return;
    }
}