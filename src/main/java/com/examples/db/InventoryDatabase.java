package com.examples.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.examples.applogic.Machine;
import com.examples.applogic.MachinePart;
import com.examples.applogic.PartType;

public class InventoryDatabase {
	private static Map<Integer, PartType> partTypes=new HashMap<>();
	
	
	
	public static List<PartType> getPartTypes() {
	    List<PartType> partTypesList = new ArrayList<>(partTypes.values());
	    return partTypesList;
	}
	
	public static PartType getPartType(int partTypeID) {
		return partTypes.get(partTypeID);
	}

	public static PartType addPartType(PartType partType) {
		
		partType.setPartTypeID(partTypes.size()+1);
		partTypes.put(partType.getPartTypeID(), partType); 
		    
		return partType;
	}
	
	public static List<PartType> searcPartTypeBySupplierID(int supplierID) {
	    List<PartType> matchingPartTypes = new ArrayList<>();
	    for (PartType partType : partTypes.values()) {
	        if (partType.getSupplierID()==supplierID) {
	            matchingPartTypes.add(partType);
	        }
	    }
	    return matchingPartTypes;
	}
	
	public static PartType updatePartType(PartType partType) {
		if (partTypes.containsKey(partType.getPartTypeID())) {
			partTypes.put(partType.getPartTypeID(), partType);
			return partType;
		}
			
		else return null;
	}
	
	public static boolean deletePartType(int partTypeID) {
		if (partTypes.containsKey(partTypes)) {
			partTypes.remove(partTypeID);
			return true;
		}
		else return false;
	}
	
	
	
	
	
	
	
}
