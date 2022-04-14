package main.java.wolfpub.dbobject;

public class Editor
{
    private Integer staffID;
    private String name;
    private String paymentSchedule;
    private String type;

	  public Editor() {
		  // TODO Auto-generated constructor stub
	  }

    public Editor(Integer staff_ID, String name, String payment_Schedule, String type)
    {
        this.staffID = staff_ID;
        this.name = name;
        this.paymentSchedule = payment_Schedule;
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

    public void displayEditorIdAndName() 
    {
      System.out.println("Editor Details");
      System.out.println("Id: " + staffID);
      System.out.println("Type: " + name);
    return;
    }
}