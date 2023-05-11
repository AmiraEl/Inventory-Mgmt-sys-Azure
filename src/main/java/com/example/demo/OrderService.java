package com.example.demo;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;


@Service
public class OrderService {



   

    @Autowired
    private OrderRepository orderRepository;
    
    public List<RequiredPart> getRequiredParts() throws IOException, URISyntaxException {
        // Build URI with parameters
        URI uri = new URIBuilder("http://localhost:8080/machines/required_parts")
                .addParameter("daysAhead", "7")
                .build();

        // Create HTTP GET request
        HttpGet httpGet = new HttpGet(uri);

        // Send HTTP GET request and get response
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        // Parse response JSON to RequiredPart list
        ObjectMapper objectMapper = new ObjectMapper();
        RequiredPart[] requiredPartsArray = objectMapper.readValue(httpResponse.getEntity().getContent(), RequiredPart[].class);
        List<RequiredPart> requiredParts = Arrays.asList(requiredPartsArray);

        // Close resources
        httpResponse.close();
        httpClient.close();

        return requiredParts;
    }
    
    public Supplier getSupplier(int supplierID) throws IOException, URISyntaxException {
        // Build URI with supplierID
        URI uri = new URIBuilder("http://localhost:8081/suppliers/" + supplierID)
                .build();

        // Create HTTP GET request
        HttpGet httpGet = new HttpGet(uri);

        // Send HTTP GET request and get response
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        // Parse response JSON to Supplier object
        ObjectMapper objectMapper = new ObjectMapper();
        Supplier supplier = objectMapper.readValue(httpResponse.getEntity().getContent(), Supplier.class);

        // Close resources
        httpResponse.close();
        httpClient.close();

        return supplier;
    }


    public List<Email> weeklyOrders() throws ParseException, IOException, URISyntaxException {
        List<Email> orderEmails = new ArrayList<>();
        
       
        List<RequiredPart> requiredParts = getRequiredParts();
        for (RequiredPart requiredPart : requiredParts) {
            Supplier supplier = getSupplier(requiredPart.getSupplierID());
            int deliveryDuration = requiredPart.getExpectedDeliveryDuration();
            int partTypeID = requiredPart.getPartTypeID();
            List<Order> pastPartOrders = searchOrdersInPastXDays(deliveryDuration, partTypeID);
            int remainingQuantity = requiredPart.getQuantity();
            for (Order order : pastPartOrders) {
            	if(order.getPartTypeID()==partTypeID) {
	                if (remainingQuantity > 0) {
	                    remainingQuantity -= order.getQuantity();
	                } else {
	                    break;
	                }}
            }
            if (remainingQuantity > 0) {
                Order order = requiredPart.toOrder(supplier.getDeliveryCharge(), "", "");
                order = addOrder(order);
                orderEmails.add(generateOrderEmail(order, supplier));
            }
        }
        return orderEmails;
    }

    public Email generateOrderEmail(Order order, Supplier supplier) {
        String subject = "Ordering " + order.getPartName();
        String body = "Dear " + supplier.getName() + ", \n" + "We would like to order " + order.getQuantity()
                + " of the part " + order.getPartName() + " \n Thank you!";
        return new Email(supplier.getEmail(), subject, body);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(int orderID) {
        return orderRepository.getOrderById(orderID);
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> searchOrderBySupplierID(int supplierID) {
        return orderRepository.getOrdersBySupplierId(supplierID);
    }

    public List<Order> searchOrdersByPartTypeId(int partTypeId) {
        return orderRepository.getOrdersByPartTypeId(partTypeId);
    }

    public List<Order> searchOrdersInPastXDays(int X, int partTypeID) {
        LocalDate startDate = LocalDate.now().minusDays(X);
     
        // Convert LocalDate to java.util.Date
        Date date = java.util.Date.from(startDate.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
        List<Order> orders=orderRepository.getOrdersBetweenDates(date,new Date());
        
        
        List<Order> neworders=new ArrayList<>();
        for (Order order: orders) {
        	if (order.getPartTypeID()==partTypeID)
        		neworders.add(order);
        }
        return neworders;
        
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public boolean deleteOrder(int orderID) {
        if (orderRepository.existsById(orderID)) {
            orderRepository.deleteById(orderID);
            return true;
        } else {
            return false;
        }
    }
}
