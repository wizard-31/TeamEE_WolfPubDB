package main.java.wolfpub.dbobject;

public class Order
{
    private int orderId;
    private double cost;
    private double shippingCost;
    private int quantity;
    private String orderDate;
    private int publicationId;
    private int distributorId;
    private String deliveryDate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Order(double cost, double shippingCost, int quantity, String orderDate, int publicationId, int distributorId, String deliveryDate) {
        this.cost = cost;
        this.shippingCost = shippingCost;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.publicationId = publicationId;
        this.distributorId = distributorId;
        this.deliveryDate = deliveryDate;
    }
}
