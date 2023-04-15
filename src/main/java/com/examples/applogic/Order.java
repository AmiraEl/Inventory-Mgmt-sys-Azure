package com.examples.applogic;

import java.text.ParseException;
import java.util.Date;

public class Order {
	
	private int orderID;
	private int partTypeID;
	private int supplierID;
	private String orderMethod;
	private int quantity;
	private Date orderDate; // new instance variable for order date
	
	public Order(int partTypeID, int supplierID, String orderMethod, int quantity, String orderDate) throws ParseException {
		// modified constructor to accept order date
		this.partTypeID = partTypeID;
		this.supplierID = supplierID;
		this.orderMethod = orderMethod;
		this.quantity = quantity;
		this.orderDate =  (Date) Utils.parseDate(orderDate, "yyyy-MM-dd");;
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
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", partTypeID=" + partTypeID + ", supplierID=" + supplierID
				+ ", orderMethod=" + orderMethod + ", quantity=" + quantity + ", orderDate=" + orderDate + "]";
	}

}
