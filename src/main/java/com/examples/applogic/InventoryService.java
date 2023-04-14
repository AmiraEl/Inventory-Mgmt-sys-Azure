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
	
	public List<PartType> searcPartTypeBySupplierID(int supplierID) {
	    return InventoryDatabase.searcPartTypeBySupplierID(supplierID);
	}
	
	public PartType updatePartType(PartType partType) {
		return InventoryDatabase.updatePartType(partType);
	}
	
	public boolean deletePartType(int partTypeID) {
		return InventoryDatabase.deletePartType(partTypeID);
	}
	
}
