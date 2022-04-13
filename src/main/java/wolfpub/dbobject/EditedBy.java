package main.java.wolfpub.dbobject;

public class EditedBy
{
    private Integer Publication_ID;
    private Integer Staff_ID;

    public EditedBy(Integer publication_ID, Integer staff_ID)
    {
        this.Publication_ID = publication_ID;
        this.Staff_ID = staff_ID;
    }

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public static String getMeta() {
        return "( publication_id, staff_id)";
    }
    
    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + Publication_ID;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + Staff_ID;
        res = res + "'";
  
        res = res + ")";
        return res;
    }
    
    public void display() {
        System.out.println("Publication Id and Editor Id Details ");
        System.out.println("PublicationId: " + Publication_ID);
        System.out.println("Editor Id: " + Staff_ID);
       
        return;
        
    }
}