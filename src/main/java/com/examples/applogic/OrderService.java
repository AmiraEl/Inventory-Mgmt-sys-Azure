package com.examples.applogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.examples.db.OrderDatabase;


@Service
public class OrderService {
	
	private MachineService machineService;
	
	
	private SupplierService supplierService;
    public OrderService() {
    	machineService=new MachineService();
    	supplierService=new SupplierService();
    }
    
    
    //@Scheduled(cron = "0 0 0 * * MON") 
    public List<Order> weeklyOrders(){
    	List<Order> orders=new ArrayList<>();
    	List<RequiredPart> requiredParts=machineService.getPartsToOrder(7);
    	for (RequiredPart requiredPart: requiredParts) {
    		Supplier supplier=supplierService.getSupplier(requiredPart.getSupplierID());
    		Order order=requiredPart.toOrder(supplier.getDeliveryCharge(),"email","");
    		orders.add(order);
    		this.addOrder(order);
    	}
    	return orders;
    }
    
    public boolean sendOrderEmail(Order order) {
    	return true;
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
