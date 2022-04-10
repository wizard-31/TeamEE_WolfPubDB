package main.java.wolfpub.dbobject;

public class Author
{
    private Integer staff_Id;
    private String name;
    private String payment_Schedule;
    private String type;

    public Author(Integer staff_Id, String name, String payment_Schedule, String type) {
        this.staff_Id = staff_Id;
        this.name = name;
        this.payment_Schedule = payment_Schedule;
        this.type = type;
    }

    //Initializing Getters and Setters
    public Integer getStaff_Id() { return staff_Id; }
    public void setStaff_Id(Integer staff_Id) { this.staff_Id = staff_Id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPayment_Schedule() { return payment_Schedule; }
    public void setPayment_Schedule(String payment_Schedule) { this.payment_Schedule = payment_Schedule; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}