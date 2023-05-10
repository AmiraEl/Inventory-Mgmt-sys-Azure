package com.examples.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.Machine;
import com.example.demo.MachinePart;

public class MachineDatabase {
	
private static Map<String,Machine> machines=new HashMap<>();
private static Map<String,MachinePart> machineParts=new HashMap<>();

	
	public static List<String> getMachineTypes() {
	    Set<String> types = new HashSet<>();
	    for (Machine machine : machines.values()) {
	        types.add(machine.getMachineType());
	    }
	    return new ArrayList<>(types);
	}
	
	public static List<Integer> getMachinePartTypeIDs() {
	    Set<Integer> types = new HashSet<>();
	    for (MachinePart machinePart : machineParts.values()) {
	        types.add(machinePart.getPartType().getId());
	    }
	    return new ArrayList<>(types);
	}
	
	
	public static List<Machine> getMachines() {
	    List<Machine> machineList = new ArrayList<>(machines.values());
	    return machineList;
	}
	
	public static List<MachinePart> getMachineParts() {
	    List<MachinePart> machinePartsList = new ArrayList<>(machineParts.values());
	    return machinePartsList;
	}
	
	public static Machine getMachine(String machineSerialNumber) {
		return machines.get(machineSerialNumber);
	}
	
	public static MachinePart getMachinePart(String serialNumber) {
		return machineParts.get(serialNumber);
	}
	
	public static Machine addMachine(Machine machine) {
		
		if (machines.containsKey(machine.getMachineSerialNumber()))
			return null;
	    machines.put(machine.getMachineSerialNumber(), machine); 
	    
	    return machine;
	}
	
	public static MachinePart addMachinePart(MachinePart machinePart) {
		
		if (machineParts.containsKey(machinePart.getSerialNumber()))
			return null;
	    machineParts.put(machinePart.getSerialNumber(), machinePart); 
	    
	    return machinePart;
	}
	
	
	public static List<Machine> searchMachineByType(String type) {
	    List<Machine> matchingMachines = new ArrayList<>();
	    for (Machine machine : machines.values()) {
	        if (machine.getMachineType().equals(type)) {
	            matchingMachines.add(machine);
	        }
	    }
	    return matchingMachines;
	}
	
	public static List<MachinePart> searchMachinePartByMachineSerialNum(String serialNum) {
	    List<MachinePart> matchingMachineParts = new ArrayList<>();
	    for (MachinePart machinePart : machineParts.values()) {
	        if (machinePart.getMachineSerialNumber().equals(serialNum)) {
	            matchingMachineParts.add(machinePart);
	        }
	    }
	    return matchingMachineParts;
	}
	
	
	
	public static List<MachinePart> searchMachinePartByPartTypeID(int partTypeID) {
	    List<MachinePart> matchingMachineParts = new ArrayList<>();
	    for (MachinePart machinePart : machineParts.values()) {
	        if (machinePart.getPartType().getId()==partTypeID) {
	            matchingMachineParts.add(machinePart);
	        }
	    }
	    return matchingMachineParts;
	}
	public static Machine updateMachine(Machine machine) {
	    if (machines.containsKey(machine.getMachineSerialNumber())) {
	        machines.put(machine.getMachineSerialNumber(), machine);
	        return machine;
	    } else {
	        return null;
	    }
	}
	
	public static MachinePart updateMachinePart(MachinePart machinePart) {
	    if (machineParts.containsKey(machinePart.getSerialNumber())) {
	        machineParts.put(machinePart.getSerialNumber(), machinePart);
	        return machinePart;
	    } else {
	        return null;
	    }
	}
	
	public static boolean deleteMachinePart(String SerialNumber) {
	    if (machineParts.containsKey(SerialNumber)) {
	        machineParts.remove(SerialNumber);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public static boolean deleteMachine(String machineSerialNumber) {
	    if (machines.containsKey(machineSerialNumber)) {
	        machines.remove(machineSerialNumber);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	

}


