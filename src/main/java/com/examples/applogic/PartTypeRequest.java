package com.examples.applogic;



public class PartTypeRequest {
    
    private String partName;
    private int lifetime;
    private int expectedDeliveryDuration;
    private double price;
    private int supplierID;


    public PartTypeRequest( String partName, int lifetime, int expectedDeliveryDuration, double price, int supplierID) {
  
        this.partName = partName;
        this.lifetime = lifetime;
        this.expectedDeliveryDuration = expectedDeliveryDuration;
        this.price = price;
        this.supplierID = supplierID;
    }
    
    
    public PartType convert() {
    	return new PartType(0, partName, lifetime, expectedDeliveryDuration,price, supplierID);
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
}


