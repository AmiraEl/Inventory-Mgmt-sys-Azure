package com.example.demo;

import com.example.demo.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT s FROM Supplier s")
    List<Supplier> getAllSuppliers();

    @Query("SELECT s FROM Supplier s WHERE s.id = :id")
    Supplier getSupplierById(int id);

    @Query("SELECT s FROM Supplier s WHERE s.name = :name")
    List<Supplier> searchSuppliersByName(String name);

    @Modifying
    @Query("DELETE FROM Supplier s WHERE s.id = :id")
    void deleteSupplier(int id);

}
