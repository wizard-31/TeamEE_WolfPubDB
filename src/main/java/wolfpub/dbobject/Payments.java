package main.java.wolfpub.dbobject;

public class Payments
{
    private Integer staffID;
    private Float salary;
    private String dateClaimed;

    public Payments(Integer staffID, Float salary, String dateClaimed)
    {
        this.staffID = staffID;
        this.salary = salary;
        this.dateClaimed = dateClaimed;
    }

    //Initializing Getters and Setters
    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public Float getSalary() { return salary; }
    public void setSalary(Float salary) { this.salary = salary; }

    public String getDateClaimed() { return dateClaimed; }
    public void setDateClaimed(String dateClaimed) { this.dateClaimed = dateClaimed; }
}