package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private PartTypeRepository partTypeRepository;

    @Autowired
    private SparePartRepository sparePartRepository;

    public List<PartType> getAllPartTypes() {
        return partTypeRepository.findAll();
    }

    public PartType getPartTypeById(int id) {
        return partTypeRepository.getPartTypeById(id);
    }

    public PartType addPartType(PartType partType) {
        return partTypeRepository.save(partType);
    }

    public void deletePartType(int id) {
        partTypeRepository.deleteById(id);
    }

    public List<PartType> searchPartTypeBySupplierID(int supplierID) {
        return partTypeRepository.searchPartTypeBySupplierId(supplierID);
    }

    public PartType updatePartType(PartType partType) {
        return partTypeRepository.save(partType);
    }

    public List<SparePart> getAllSpareParts() {
        return sparePartRepository.findAll();
    }

    public SparePart getSparePartBySerialNumber(String serialNumber) {
        return sparePartRepository.getSparePartBySerialNumber(serialNumber);
    }

    public SparePart addSparePart(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }

    public void deleteSparePart(String serialNumber) {
        sparePartRepository.deleteById(serialNumber);
    }

    public List<SparePart> searchSparePartByPartTypeID(int partTypeID) {
        return sparePartRepository.searchSparePartByPartTypeID(partTypeID);
    }

    public SparePart updateSparePart(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }
    
    public int reserveSpareParts(int partTypeID, String machineSerialNum, int quantityNeeded) {
        List<SparePart> spareParts = sparePartRepository.findAll();
        for (SparePart sparePart : spareParts) {
        	
            if (sparePart.getPartTypeID()==partTypeID && sparePart.isReserved() &&sparePart.getReservedMachineSerialNum().equals(machineSerialNum)) {
            	quantityNeeded--;
            }
            else if (sparePart.getPartTypeID()==partTypeID && !sparePart.isReserved()){
            	
            	sparePart.setReserved(true);
                sparePart.setReservedMachineSerialNum(machineSerialNum);
                sparePartRepository.save(sparePart);
                quantityNeeded--;
                System.out.println(sparePart);
            	
            }
            
            	
        }
        return quantityNeeded;
    }
}



