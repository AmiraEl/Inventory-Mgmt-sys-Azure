package com.example.supplierservice;

public class Supplier {
    private int ID;
    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String address;
    private double deliveryCharge;

    public Supplier(){

    }
    

    public Supplier(String name, String email, String phoneNumber, String website, String address, double deliveryCharge) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.address = address;
        this.deliveryCharge = deliveryCharge;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", website='" + website + '\'' +
                ", address='" + address + '\'' +
                ", deliveryCharge=" + deliveryCharge +
                '}';
    }
}