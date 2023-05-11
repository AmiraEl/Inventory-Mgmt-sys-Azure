package com.example.supplierservice;

import com.example.supplierservice.SupplierDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    public SupplierService() {
    }
    public Supplier getSupplier(int ID) {
        return SupplierDatabase.getSupplier(ID);
    }
    public List<Supplier> getAllSuppliers(){
        return SupplierDatabase.getSuppliers();
    }

    public List<Supplier> searchSupplier(Supplier supplier){
        return SupplierDatabase.searchSupplier(supplier);
    }

    public Supplier addSupplier(Supplier Supplier) {
        return SupplierDatabase.addSupplier(Supplier);
    }

    public Supplier updateSupplier(Supplier Supplier) {
        return SupplierDatabase.updateSupplier(Supplier);
    }
    public boolean deleteSupplier(int ID) {
        return SupplierDatabase.deleteSupplier(ID);
    }

}