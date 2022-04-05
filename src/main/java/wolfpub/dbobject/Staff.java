package main.java.wolfpub.dbobject;

public class Staff
{
    private Integer Staff_ID;
    private String Name;
    private String Payment_Schedule;
    private String Type;

    public Staff(Integer staff_ID, String name, String payment_Schedule, String type)
    {
        this.Staff_ID = staff_ID;
        this.Name = name;
        this.Payment_Schedule = payment_Schedule;
        this.Type = type;
    }

    //Initializing Getters and Setters
    public Integer getStaff_ID() { return Staff_ID; }
    public void setStaff_ID(Integer staff_ID) { this.Staff_ID = staff_ID; }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public String getPayment_Schedule() { return Payment_Schedule; }
    public void setPayment_Schedule(String payment_Schedule) { this.Payment_Schedule = payment_Schedule; }

    public String getType() { return Type; }
    public void setType(String type) { this.Type = type; }
}
