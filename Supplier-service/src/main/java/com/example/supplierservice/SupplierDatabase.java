package com.example.supplierservice;

import java.util.*;

public class SupplierDatabase {

    private static Map<Integer, Supplier> Suppliers = new HashMap<>();

    public static List<Supplier> getSuppliers() {
        return new ArrayList<>(Suppliers.values());
    }

    public static Supplier getSupplier(int ID) {
        return Suppliers.get(ID);
    }

    public static Supplier addSupplier(Supplier Supplier) {
        Supplier.setID(Suppliers.size()+1);
        Suppliers.put(Supplier.getID(), Supplier);

        return Supplier;
    }

    //pass the parameter as 0 for ID or "" if you don't want to search using that parameter
    public static List<Supplier> searchSupplier(Supplier supplier) {
        List<Supplier> matchingSuppliers = new ArrayList<>();
        for (Supplier search : Suppliers.values()) {
            if (!((search.getID() == supplier.getID()) || (supplier.getID() == 0))) {
                continue;
            }
            if (!((Objects.equals(search.getName(), supplier.getName())) || (Objects.equals(supplier.getName(), "")))) {
                continue;
            }
            if (!((Objects.equals(search.getAddress(), supplier.getAddress())) || (Objects.equals(supplier.getAddress(), "")))) {
                continue;
            }
            if (!((Objects.equals(search.getEmail(), supplier.getEmail())) || (Objects.equals(supplier.getEmail(), "")))) {
                continue;
            }
            if (!((Objects.equals(search.getWebsite(), supplier.getWebsite())) || (Objects.equals(supplier.getWebsite(), "")))) {
                continue;
            }
            matchingSuppliers.add(search);
        }
        return matchingSuppliers;
    }

//    public static List<Supplier> searchSupplierByID(int ID) {
//        List<Supplier> matchingSuppliers = new ArrayList<>();
//        for (Supplier Supplier : Suppliers.values()) {
//            if (Supplier.getID() == ID) {
//                matchingSuppliers.add(Supplier);
//            }
//        }
//        return matchingSuppliers;
//    }

    public static Supplier updateSupplier(Supplier Supplier) {
        if (Suppliers.containsKey(Supplier.getID())) {
            Suppliers.put(Supplier.getID(), Supplier);
            return Supplier;
        } else {
            return null;
        }
    }

    public static boolean deleteSupplier(int ID) {
        if (Suppliers.containsKey(ID)) {
            Suppliers.remove(ID);
            return true;
        } else {
            return false;
        }
    }


}