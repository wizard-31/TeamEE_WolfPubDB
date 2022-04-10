package main.java.wolfpub.dbobject;

public class Distributor
{
    private Integer distributor_Id;
    private String phone_Number;
    private String address;
    private String name;
    private Float remaining_Balance;
    private String city;
    private String type;

    public Distributor(Integer distributor_Id, String phone_Number, String address, String name, Float remaining_Balance, String city, String type)
    {
        this.distributor_Id = distributor_Id;
        this.phone_Number = phone_Number;
        this.address = address;
        this.name = name;
        this.remaining_Balance = remaining_Balance;
        this.city = city;
        this.type = type;
    }

    //Initializing Getters and Setters
    public Integer getDistributor_Id() { return distributor_Id; }
    public void setDistributor_Id(Integer distributor_Id) { this.distributor_Id = distributor_Id; }

    public String getPhone_Number() { return phone_Number; }
    public void setPhone_Number(String phone_Number) { this.phone_Number = phone_Number; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getRemaining_Balance() { return remaining_Balance; }
    public void setRemaining_Balance(Float remaining_Balance) { this.remaining_Balance = remaining_Balance; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}