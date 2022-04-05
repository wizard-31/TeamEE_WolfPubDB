package main.java.wolfpub.dbobject;

import java.util.Date;

public class Payments
{
    private Integer Payment_ID;
    private Integer Staff_ID;
    private Float Salary;
    private Date Date_Claimed;

    public Payments(Integer payment_ID, Integer staff_ID, Float salary, Date date_Claimed)
    {
        this.Payment_ID = payment_ID;
        this.Staff_ID = staff_ID;
        this.Salary = salary;
        this.Date_Claimed = date_Claimed;
    }

    //Initializing Getters and Setters
    public Integer getPayment_ID() { return Payment_ID; }
    public void setPayment_ID(Integer payment_ID) { this.Payment_ID = payment_ID; }

    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public Float getSalary() { return Salary; }
    public void setSalary(Float salary) { this.Salary = salary; }

    public Date getDate_Claimed() { return Date_Claimed; }
    public void setDate_Claimed(Date date_Claimed) { this.Date_Claimed = date_Claimed; }
}