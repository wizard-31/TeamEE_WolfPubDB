package main.java.wolfpub.dbobject;

public class EditedBy
{
    private Integer publication_Id;
    private Integer staff_Id;

    public EditedBy(Integer publication_ID, Integer staff_ID)
    {
        this.publication_Id = publication_ID;
        this.staff_Id = staff_ID;
    }

    //Initializing Getters and Setters
    public Integer getPublication_ID() { return publication_Id; }
    public void setPublication_ID(Integer publication_ID) { this.publication_Id = publication_ID; }

    public Integer getStaff_ID() { return staff_Id; }
    public void setStaff_ID(Integer staff_ID) { this.staff_Id = staff_ID; }
    
    public static String getMeta() {
        return "( publication_id, staff_id)";
    }
    
    public String toString() {
        String res = "(";
        res = res + "'";
        res = res + publication_Id;
        res = res + "'";
        res = res + ",";
        res = res + "'";
        res = res + staff_Id;
        res = res + "'";
  
        res = res + ")";
        return res;
    }
    
    public void display() {
        System.out.println("Publication Id and Editor Id Details ");
        System.out.println("PublicationId: " + publication_Id);
        System.out.println("Editor Id: " + staff_Id);
       
        return;
        
    }
}


