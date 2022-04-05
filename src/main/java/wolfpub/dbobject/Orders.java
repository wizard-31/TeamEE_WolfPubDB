package main.java.wolfpub.dbobject;

import java.util.Date;

public class Orders
{
    private Integer Order_ID;
    private Float Cost;
    private Float Shipping_Cost;
    private Integer Quantity;
    private Date Order_Date;
    private Integer Publication_ID;
    private Integer Distributor_ID;

    public Orders(Integer order_ID, Float cost, Float shipping_Cost, Integer quantity, Date order_Date, Integer publication_ID, Integer distributor_ID)
    {
        this.Order_ID = order_ID;
        this.Cost = cost;
        this.Shipping_Cost = shipping_Cost;
        this.Quantity = quantity;
        this.Order_Date = order_Date;
        this.Publication_ID = publication_ID;
        this.Distributor_ID = distributor_ID;
    }

    //Initializing Getters and Setters
    public Integer getOrder_ID() { return Order_ID; }
    public void setOrder_ID(Integer order_ID) { this.Order_ID = order_ID; }

    public Float getCost() { return Cost; }
    public void setCost(Float cost) { this.Cost = cost; }

    public Float getShipping_Cost() { return Shipping_Cost; }
    public void setShipping_Cost(Float shipping_Cost) { this.Shipping_Cost = shipping_Cost; }

    public Integer getQuantity() { return Quantity; }
    public void setQuantity(Integer quantity) { this.Quantity = quantity; }

    public Date getOrder_Date() { return Order_Date; }
    public void setOrder_Date(Date order_Date) { this.Order_Date = order_Date; }

    public Integer getPublication_ID() { return Publication_ID; }
    public void setPublication_ID(Integer publication_ID) { this.Publication_ID = publication_ID; }

    public Integer getDistributor_ID() { return Distributor_ID; }
    public void setDistributor_ID(Integer distributor_ID) { this.Distributor_ID = distributor_ID; }
}
