package main.java.wolfpub.dbobject;

import java.util.Date;

public class Payments
{
    private Integer Staff_ID;
    private Float Salary;
    private String Date_Claimed;

    public Payments(Integer staff_ID, Float salary, String date_Claimed)
    {
        this.Staff_ID = staff_ID;
        this.Salary = salary;
        this.Date_Claimed = date_Claimed;
    }

    //Initializing Getters and Setters
    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public Float getSalary() { return Salary; }
    public void setSalary(Float salary) { this.Salary = salary; }

    public String getDate_Claimed() { return Date_Claimed; }
    public void setDate_Claimed(String date_Claimed) { this.Date_Claimed = date_Claimed; }
}