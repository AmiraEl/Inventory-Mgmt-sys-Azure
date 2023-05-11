package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
	private SupplierRepository supplierRepository;

   

    public Supplier getSupplier(int ID) {
        return supplierRepository.findById(ID).orElse(null);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public List<Supplier> searchSupplier(Supplier supplier) {
        // You can implement search functionality in the repository interface itself using @Query
        // annotations or by using the built-in query methods provided by Spring Data JPA.
        // For example: supplierRepository.findByNameAndAddress(supplier.getName(), supplier.getAddress())
        return null;
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public boolean deleteSupplier(int ID) {
        try {
            supplierRepository.deleteById(ID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
