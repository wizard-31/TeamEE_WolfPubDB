package main.java.wolfpub.dbobject;

public class Distributor
{
    private Integer Distributor_ID;
    private String Phone_Number;
    private String Address;
    private String Name;
    private Float Remaining_Balance;
    private String City;
    private String Type;

    public Distributor(Integer distributor_ID, String phone_Number, String address, String name, Float remaining_Balance, String city, String type)
    {
        this.Distributor_ID = distributor_ID;
        this.Phone_Number = phone_Number;
        this.Address = address;
        this.Name = name;
        this.Remaining_Balance = remaining_Balance;
        this.City = city;
        this.Type = type;
    }

    //Initializing Getters and Setters
    public Integer getDistributor_ID() { return Distributor_ID; }
    public void setDistributor_ID(Integer distributor_ID) { this.Distributor_ID = distributor_ID; }

    public String getPhone_Number() { return Phone_Number; }
    public void setPhone_Number(String phone_Number) { this.Phone_Number = phone_Number; }

    public String getAddress() { return Address; }
    public void setAddress(String address) { this.Address = address; }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public Float getRemaining_Balance() { return Remaining_Balance; }
    public void setRemaining_Balance(Float remaining_Balance) { this.Remaining_Balance = remaining_Balance; }

    public String getCity() { return City; }
    public void setCity(String city) { this.City = city; }

    public String getType() { return Type; }
    public void setType(String type) { this.Type = type; }
}