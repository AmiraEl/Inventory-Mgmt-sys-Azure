package com.example.supplierservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierService SupplierService;

    public SupplierController() {
        SupplierService = new SupplierService();
    }

    @GetMapping
    public List<Supplier> getSuppliers() {
        return SupplierService.getAllSuppliers();

    }

    @GetMapping(path = "{SupplierID}")
    public Supplier getSupplier(@PathVariable("SupplierID") int SupplierID) {
        return SupplierService.getSupplier(SupplierID);
    }

    /*@GetMapping(path = "/querySearch")
    public List<Supplier> searchSupplier(@RequestBody Supplier Supplier) {
        return SupplierService.searchSupplier(Supplier);
    }*/

    @PostMapping
    public String addSupplier(@RequestBody Supplier Supplier) {

        Supplier SupplierAdded = SupplierService.addSupplier(Supplier);
        return SupplierAdded.toString();

    }

    @PutMapping(path = "{SupplierID}")
    public String updateSupplier(@PathVariable("SupplierID") int SupplierID, @RequestBody Supplier Supplier) {
        Supplier.setID(SupplierID);
        Supplier updatedSupplier = SupplierService.updateSupplier(Supplier);
        if (updatedSupplier == null) {
            return "This Supplier doesn't exist";
        } else return "Supplier Updated!\n" + updatedSupplier;
    }

    @DeleteMapping(path = "{SupplierID}")
    public String deleteSupplier(@PathVariable("SupplierID") int SupplierID) {
        if (SupplierService.deleteSupplier(SupplierID))
            return "Supplier Deleted";
        else return "Supplier doesn't exist";
    }


}