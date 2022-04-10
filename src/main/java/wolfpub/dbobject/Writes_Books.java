package main.java.wolfpub.dbobject;

public class Writes_Books
{
    private Integer Staff_ID;
    private Integer Publication_ID;

    public Writes_Books(Integer staff_ID, Integer publication_ID)
    {
        this.Staff_ID = staff_ID;
        this.Publication_ID = publication_ID;
    }

    //Initializing Getters and Setters
    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }
}