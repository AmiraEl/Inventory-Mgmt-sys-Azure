package com.examples.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.examples.applogic.Order;
import com.examples.applogic.Utils;

public class OrderDatabase {
    private static Map<Integer, Order> orders = new HashMap<>();

    public static List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>(orders.values());
        return orderList;
    }

    public static Order getOrder(int orderID) {
        return orders.get(orderID);
    }

    public static Order addOrder(Order order) {
        order.setOrderID(orders.size() + 1);
        orders.put(order.getOrderID(), order);
        return order;
    }

    public static List<Order> searchOrdersBySupplierID(int supplierID) {
        List<Order> matchingOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getSupplierID() == supplierID) {
                matchingOrders.add(order);
            }
        }
        return matchingOrders;
    }

    public static Order updateOrder(Order order) {
        if (orders.containsKey(order.getOrderID())) {
            orders.put(order.getOrderID(), order);
            return order;
        } else {
            return null;
        }
    }

    public static boolean deleteOrder(int orderID) {
        if (orders.containsKey(orderID)) {
            orders.remove(orderID);
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Order> searchOrdersByPartTypeId(int partTypeId) {
        List<Order> matchingOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getPartTypeID() == partTypeId) {
                matchingOrders.add(order);
            }
        }
        return matchingOrders;
    }
    
    public static List<Order> searchOrdersInPastXDays(int X){
    	List<Order> matchingOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (Utils.daysFromDate(order.getOrderDate())<=X) {
                matchingOrders.add(order);
            }
        }
        return matchingOrders;
    }
}
