package com.examples.applogic;

public class RequiredPart {
    
    private int partTypeID;
    private String partName; 
    private int supplierID;
    private double totalItemsPrice;
    private double itemPrice;
    private int quantity;
    
    public RequiredPart() {
    	
    }

    public RequiredPart(PartType partType, int quantity) {
        this.partTypeID = partType.getPartTypeID();
        this.partName = partType.getPartName();
        this.supplierID = partType.getSupplierID();
        this.itemPrice=partType.getPrice();
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addToQuantity(int count) {
        this.quantity = quantity+count;
    }
    
    public void setItemPrice(double itemPrice) {
    	this.itemPrice=itemPrice;
    	
    }
    
    public double getItemPrice() {
    	return this.itemPrice;
    }

    @Override
    public String toString() {
        return "RequiredPart [partTypeID=" + partTypeID + ", partName=" + partName + ", supplierID=" + supplierID + ", quantity=" + quantity+", itemPrice=" + itemPrice + "]";
    }
}
