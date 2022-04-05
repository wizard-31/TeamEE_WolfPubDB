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
}



