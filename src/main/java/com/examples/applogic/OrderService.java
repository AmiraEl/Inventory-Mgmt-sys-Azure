package com.examples.applogic;

import java.util.ArrayList;
import java.util.List;

import com.examples.db.OrderDatabase;

public class OrderService {

    public OrderService() {

    }

    public List<Order> getOrders() {
        return OrderDatabase.getOrders();
    }

    public Order getOrder(int orderID) {
        return OrderDatabase.getOrder(orderID);
    }

    public Order addOrder(Order order) {
        return OrderDatabase.addOrder(order);
    }

    public List<Order> searchOrderBySupplierID(int supplierID) {
        return OrderDatabase.searchOrdersBySupplierID(supplierID);
    }
    
    public List<Order> searchOrdersByPartTypeId(int partTypeId) {
        return OrderDatabase.searchOrdersByPartTypeId(partTypeId);
    }
    public List<Order> searchOrdersInPastXDays(int X){
    	return OrderDatabase.searchOrdersInPastXDays(X);
    }

    public Order updateOrder(Order order) {
        return OrderDatabase.updateOrder(order);
    }

    public boolean deleteOrder(int orderID) {
        return OrderDatabase.deleteOrder(orderID);
    }
}
