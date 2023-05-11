package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Order;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o")
    List<Order> getAllOrders();

    @Query("SELECT o FROM Order o WHERE o.orderID = :orderID")
    Order getOrderById(int orderID);

    @Query("SELECT o FROM Order o WHERE o.supplierID = :supplierID")
    List<Order> getOrdersBySupplierId(int supplierID);

    @Query("SELECT o FROM Order o WHERE o.partTypeID = :partTypeID")
    List<Order> getOrdersByPartTypeId(int partTypeID);

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> getOrdersBetweenDates(Date startDate, Date endDate);

    @Modifying
    @Query("DELETE FROM Order o WHERE o.orderID = :orderID")
    void deleteOrder(int orderID);
    
    @Query("SELECT o FROM Order o WHERE o.partTypeID = :partTypeId AND o.orderDate >= :startDate")
    List<Order> findOrdersByPartTypeAndStartDate(int partTypeId, LocalDate startDate);


}
