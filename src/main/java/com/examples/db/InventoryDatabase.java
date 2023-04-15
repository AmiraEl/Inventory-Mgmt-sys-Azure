package com.examples.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.examples.applogic.PartType;
import com.examples.applogic.SparePart;

public class InventoryDatabase {
	private static Map<Integer, PartType> partTypes=new HashMap<>();
	private static Map<String, SparePart> spareParts=new HashMap<>();
	
	
	
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
	
	public static List<PartType> searchPartTypeBySupplierID(int supplierID) {
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
		if (partTypes.containsKey(partTypeID)) {
			partTypes.remove(partTypeID);
			return true;
		}
		else return false;
	}
	
	
	public static List<SparePart> getSpareParts() {
	    List<SparePart> sparePartsList = new ArrayList<>(spareParts.values());
	    return sparePartsList;
	}
	
	public static SparePart getSparePart(String serialNum) {
		return spareParts.get(serialNum);
	}

	public static SparePart addSparePart(SparePart sparePart) {
		
		if(spareParts.containsKey(sparePart.getSerialNumber()))
			return null;
		else {
			spareParts.put(sparePart.getSerialNumber(), sparePart);
			return sparePart;
		}
		
	}
	
	public static List<SparePart> searchSparePartByPartTypeID(int partTypeID) {
	    List<SparePart> matchingSpareParts = new ArrayList<>();
	    for (SparePart sparePart : spareParts.values()) {
	        if (sparePart.getPartTypeID()==partTypeID) {
	        	matchingSpareParts.add(sparePart);
	        }
	    }
	    return matchingSpareParts;
	}
	
	
	public static SparePart updateSparePart(SparePart sparePart) {
		if (spareParts.containsKey(sparePart.getSerialNumber())) {
			spareParts.put(sparePart.getSerialNumber(), sparePart);
			return sparePart;
		}
			
		else return null;
	}
	
	public static boolean deleteSparePart(String serialNum) {
		if (spareParts.containsKey(serialNum)) {
			spareParts.remove(serialNum);
			return true;
		}
		else return false;
	}
	
	
	
	
}
