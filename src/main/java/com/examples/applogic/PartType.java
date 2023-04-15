package com.examples.applogic;

public class PartType {
    private int partTypeID;
    private String partName;
    private int lifetime;
    private int expectedDeliveryDuration;
    private double price;
    private int supplierID;


    public PartType( String partName, int lifetime, int expectedDeliveryDuration, double price, int supplierID) {
       
        this.partName = partName;
        this.lifetime = lifetime;
        this.expectedDeliveryDuration = expectedDeliveryDuration;
        this.price = price;
        this.supplierID = supplierID;
    }
    
    
    public int getPartTypeID() {
        return partTypeID;
    }

    public String getPartName() {
        return partName;
    }

    public int getLifetime() {
        return lifetime;
    }

    public int getExpectedDeliveryDuration() {
        return expectedDeliveryDuration;
    }

    public double getPrice() {
        return price;
    }

    public int getSupplierID() {
        return supplierID;
    }


    public void setPartTypeID(int partTypeID) {
        this.partTypeID = partTypeID;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void setExpectedDeliveryDuration(int expectedDeliveryDuration) {
        this.expectedDeliveryDuration = expectedDeliveryDuration;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    public String toString() {
        return "Part Type ID: " + partTypeID + "\n" +
               "Part Name: " + partName + "\n" +
               "Lifetime: " + lifetime + "\n" +
               "Expected Delivery Duration: " + expectedDeliveryDuration + "\n" +
               "Price: $" + price + "\n" +
               "Supplier ID: " + supplierID + "\n";
    }
}

