package main.java.wolfpub.dbobject;

public class Distributor
{
    private Integer distributorID;
    private String phoneNumber;
    private String address;
    private String name;
    private Float remainingBalance;
    private String city;
    private String type;
    private String contactPerson;

    public Distributor(String phoneNumber, String address, String name, Float remainingBalance, String city, String type, String contactPerson) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.remainingBalance = remainingBalance;
        this.city = city;
        this.type = type;
        this.contactPerson = contactPerson;
    }

    public Distributor(Integer distributorID, String phoneNumber, String address, String name, Float remainingBalance, String city, String type, String contactPerson) {
        this.distributorID = distributorID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.remainingBalance = remainingBalance;
        this.city = city;
        this.type = type;
        this.contactPerson = contactPerson;
    }

    public Integer getDistributorID() {
        return distributorID;
    }

    public void setDistributorID(Integer distributorID) {
        this.distributorID = distributorID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(Float remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}