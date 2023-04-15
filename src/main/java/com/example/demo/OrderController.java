package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.examples.applogic.Email;
import com.examples.applogic.Order;
import com.examples.applogic.OrderService;



@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private OrderService orderService;
	
	public OrderController() {
		orderService=new OrderService();
	}
	
	@GetMapping
	public List<Order> getOrders() {
        return orderService.getOrders();
    }
	
	//dummy function
	@GetMapping("required_emails")
	public List<Email> getWeeklyOrders() {
        return orderService.weeklyOrders();
    }
	
	@GetMapping(path="{orderID}")
    public Order getOrder(@PathVariable("orderID")int orderID) {
        return orderService.getOrder(orderID);
    }
	@PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
	
	
	@GetMapping(path="supplier/{supplierID}")
    public List<Order> searchOrderBySupplierID(@PathVariable("supplierID")int supplierID) {
        return orderService.searchOrderBySupplierID(supplierID);
    }
    
	@GetMapping(path="part_type/{partTypeID}")
    public List<Order> searchOrdersByPartTypeId(@PathVariable("partTypeID")int partTypeId) {
        return orderService.searchOrdersByPartTypeId(partTypeId);
    }
	
	
	@PutMapping(path="{orderID}")
    public String updateOrder(@PathVariable("orderID")int orderID, @RequestBody Order order) {
    	order.setOrderID(orderID);
    	Order updatedOrder=orderService.updateOrder(order);
    	if (updatedOrder==null)
    		return "order doesn't exist";
    	else return updatedOrder.toString();
    }
	
	@DeleteMapping(path="{orderID}")
    public String deleteOrder(@PathVariable("orderID")int orderID) {
        if( orderService.deleteOrder(orderID)) {
        	return "order deleted";
        	
        }
        else return "order doesn't exist";
    }

}
