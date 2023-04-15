package com.examples.applogic;

import java.util.ArrayList;
import java.util.List;

import com.examples.db.InventoryDatabase;

public class InventoryService {
	
	
	public InventoryService() {
		
	}
	
	public List<PartType> getPartTypes(){
		return InventoryDatabase.getPartTypes();
	}
	public PartType getPartType(int partTypeID) {
		return InventoryDatabase.getPartType(partTypeID);
	}

	public PartType addPartType(PartType partType) {
		
		
		return InventoryDatabase.addPartType(partType);
	}
	
	public List<PartType> searchPartTypeBySupplierID(int supplierID) {
	    return InventoryDatabase.searchPartTypeBySupplierID(supplierID);
	}
	
	public PartType updatePartType(PartType partType) {
		return InventoryDatabase.updatePartType(partType);
	}
	
	public boolean deletePartType(int partTypeID) {
		return InventoryDatabase.deletePartType(partTypeID);
	}
	
	public List<SparePart> getSpareParts() {
	    return InventoryDatabase.getSpareParts();
	}
	
	public SparePart getSparePart(String serialNum) {
		return InventoryDatabase.getSparePart(serialNum);
	}

	public SparePart addSparePart(SparePart sparePart) {
		
		return InventoryDatabase.addSparePart(sparePart);
		
	}
	
	public List<SparePart> searchSparePartByPartTypeID(int partTypeID) {
	    return InventoryDatabase.searchSparePartByPartTypeID(partTypeID);
	}
	
	public SparePart updateSparePart(SparePart sparePart) {
		return InventoryDatabase.updateSparePart(sparePart);
	}
	
	public boolean deleteSparePart(String serialNum) {
		return InventoryDatabase.deleteSparePart(serialNum);
	}
	
	public int reserveSpareParts(int partTypeID, String machineSerialNum, int quantityNeeded) {
		List<SparePart> spareParts =InventoryDatabase.searchSparePartByPartTypeID(partTypeID);
		for (SparePart sparePart: spareParts) {
			if(quantityNeeded>0) {
				if (sparePart.isReserved()) {
					if (sparePart.getReservedMachineSerialNum().equals(machineSerialNum)){
						quantityNeeded--;
					}
				} else {
					sparePart.setReserved(true);
					sparePart.setReservedMachineSerialNum(machineSerialNum);
					InventoryDatabase.updateSparePart(sparePart);
					quantityNeeded--;
				}
			}
		}
		
		
		return quantityNeeded;
	}
}
