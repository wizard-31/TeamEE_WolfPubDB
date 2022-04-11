package main.java.wolfpub.dbobject;

public class Editor
{
    private Integer staff_Id;
    private String name;
    private String payment_Schedule;
    private String type;

    public Editor(Integer staff_ID, String name, String payment_Schedule, String type)
    {
        this.staff_Id = staff_ID;
        this.name = name;
        this.payment_Schedule = payment_Schedule;
        this.type = type;
    }

  

	public Editor() {
		// TODO Auto-generated constructor stub
	}

	//Initializing Getters and Setters
    public Integer getStaff_ID() { return staff_Id; }
    public void setStaff_ID(Integer staff_ID) { this.staff_Id = staff_ID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPayment_Schedule() { return payment_Schedule; }
    public void setPayment_Schedule(String payment_Schedule) { this.payment_Schedule = payment_Schedule; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    
    public void displayEditorIdAndName() {
        System.out.println("Editor Details");
        System.out.println("Id: " + staff_Id);
        System.out.println("Type: " + name);
   
        return;
        
    }
}
