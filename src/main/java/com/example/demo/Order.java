package com.example.demo;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    private int partTypeID;
    private String partName;
    private int supplierID;
    private String orderMethod;
    private int quantity;
    private Date orderDate;

    private double itemsTotalPrice;
    private double deliveryCharge;

    public Order() {}

    public Order(int partTypeID, String partName, int supplierID, String orderMethod, int quantity, Date orderDate, double itemsTotalPrice, double deliveryCharge) {
        this.partTypeID = partTypeID;
        this.partName = partName;
        this.supplierID = supplierID;
        this.orderMethod = orderMethod;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.itemsTotalPrice = itemsTotalPrice;
        this.deliveryCharge = deliveryCharge;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPartTypeID() {
        return partTypeID;
    }

    public void setPartTypeID(int partTypeID) {
        this.partTypeID = partTypeID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getItemsTotalPrice() {
        return itemsTotalPrice;
    }

    public void setItemsTotalPrice(double itemsTotalPrice) {
        this.itemsTotalPrice = itemsTotalPrice;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", partTypeID=" + partTypeID +
                ", partName='" + partName + '\'' +
                ", supplierID=" + supplierID +
                ", orderMethod='" + orderMethod + '\'' +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", itemsTotalPrice=" + itemsTotalPrice +
                ", deliveryCharge=" + deliveryCharge +
                '}';
    }
}
