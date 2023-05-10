package com.examples.applogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.MachineService;
import com.example.demo.RequiredPart;
import com.examples.db.OrderDatabase;


@Service
public class OrderService {
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private SupplierService supplierService;
    public OrderService() {
    	//machineService=new MachineService();
    	//supplierService=new SupplierService();
    }
    
    //dummy function
    //@Scheduled(cron = "0 0 0 * * MON") 
    public List<Email> weeklyOrders(){
    	List<Email> orderEmails=new ArrayList<>();
    	List<RequiredPart> requiredParts=machineService.getPartsToOrder(7);
    	for (RequiredPart requiredPart: requiredParts) {
    		Supplier supplier=supplierService.getSupplier(requiredPart.getSupplierID());
    		int deliveryDuration=requiredPart.getExpectedDeliveryDuration();
    		int partTypeID=requiredPart.getPartTypeID();
    		List<Order> pastPartOrders=OrderDatabase.searchOrdersInPastXDays(deliveryDuration, partTypeID);
    		for (Order order:pastPartOrders) {
    			if (requiredPart.getQuantity()>0) {
    				requiredPart.subtractFromQuantity(order.getQuantity());
    			} else break;
    		}
    		if (requiredPart.getQuantity()>0) {
    			Order order=requiredPart.toOrder(supplier.getDeliveryCharge(),"email","");
    			Email email=generateOrderEmail(order,supplier);
    			orderEmails.add(email);
    			this.addOrder(order);

    		}
    		
    		
    	}
    	return orderEmails;
    }
    
    //incomplete function
    public Email generateOrderEmail(Order order, Supplier supplier) {
    	
    		String subject="Ordering "+ order.getPartName();
    		String body="Dear "+supplier.getName()+", \n"+"We would like to order "+order.getQuantity()
    		+" of the part "+ order.getPartName()+" \n Thank you!";
    	 return new Email(supplier.getEmail(), subject, body);
    	
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
    public List<Order> searchOrdersInPastXDays(int X, int partTypeID){
    	return OrderDatabase.searchOrdersInPastXDays(X, partTypeID);
    }

    public Order updateOrder(Order order) {
        return OrderDatabase.updateOrder(order);
    }

    public boolean deleteOrder(int orderID) {
        return OrderDatabase.deleteOrder(orderID);
    }
}
