package main.java.wolfpub.dbobject;

public class Staff
{
    private Integer staffID;
    private String name;
    private String paymentSchedule;
    private String type;

    public Staff(Integer staffID, String name, String paymentSchedule, String type)
    {
        this.staffID = staffID;
        this.name = name;
        this.paymentSchedule = paymentSchedule;
        this.type = type;
    }

    //Initializing Getters and Setters
    public Integer getStaffID() { return staffID; }
    public void setStaffID(Integer staffID) { this.staffID = staffID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPaymentSchedule() { return paymentSchedule; }
    public void setPaymentSchedule(String paymentSchedule) { this.paymentSchedule = paymentSchedule; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
