package com.examples.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.examples.applogic.Machine;
import com.examples.applogic.MachinePart;

public class MachineDatabase {
	
private static Map<String,Machine> machines;
private static Map<String,MachinePart> machineParts;

	public MachineDatabase() {
		machines = new HashMap<>();
		machineParts=new HashMap<>();
	}
	public List<String> getMachineTypes() {
	    Set<String> types = new HashSet<>();
	    for (Machine machine : machines.values()) {
	        types.add(machine.getMachineType());
	    }
	    return new ArrayList<>(types);
	}
	
	public List<Integer> getMachinePartTypeIDs() {
	    Set<Integer> types = new HashSet<>();
	    for (MachinePart machinePart : machineParts.values()) {
	        types.add(machinePart.getPartTypeID());
	    }
	    return new ArrayList<>(types);
	}
	
	
	public List<Machine> getMachines() {
	    List<Machine> machineList = new ArrayList<>(machines.values());
	    return machineList;
	}
	
	public List<MachinePart> getMachineParts() {
	    List<MachinePart> machinePartsList = new ArrayList<>(machineParts.values());
	    return machinePartsList;
	}
	
	public Machine getMachine(String machineSerialNumber) {
		return machines.get(machineSerialNumber);
	}
	
	public MachinePart getMachinePart(String serialNumber) {
		return machineParts.get(serialNumber);
	}
	
	public Machine addMachine(Machine machine) {
		
		if (machines.containsKey(machine.getMachineSerialNumber()))
			return null;
	    machines.put(machine.getMachineSerialNumber(), machine); 
	    
	    return machine;
	}
	
	public MachinePart addMachinePart(MachinePart machinePart) {
		
		if (machineParts.containsKey(machinePart.getSerialNumber()))
			return null;
	    machineParts.put(machinePart.getSerialNumber(), machinePart); 
	    
	    return machinePart;
	}
	
	
	public List<Machine> searchMachineByType(String type) {
	    List<Machine> matchingMachines = new ArrayList<>();
	    for (Machine machine : machines.values()) {
	        if (machine.getMachineType().equals(type)) {
	            matchingMachines.add(machine);
	        }
	    }
	    return matchingMachines;
	}
	
	public List<MachinePart> searchMachinePartByMachineSerialNum(String serialNum) {
	    List<MachinePart> matchingMachines = new ArrayList<>();
	    for (MachinePart machinePart : machineParts.values()) {
	        if (machinePart.getMachineSerialNumber().equals(serialNum)) {
	            matchingMachines.add(machinePart);
	        }
	    }
	    return matchingMachines;
	}
	
	public Machine updateMachine(Machine machine) {
	    if (machines.containsKey(machine.getMachineSerialNumber())) {
	        machines.put(machine.getMachineSerialNumber(), machine);
	        return machine;
	    } else {
	        return null;
	    }
	}
	
	public MachinePart updateMachinePart(MachinePart machinePart) {
	    if (machineParts.containsKey(machinePart.getMachineSerialNumber())) {
	        machineParts.put(machinePart.getMachineSerialNumber(), machinePart);
	        return machinePart;
	    } else {
	        return null;
	    }
	}
	
	public boolean deleteMachinePart(String SerialNumber) {
	    if (machineParts.containsKey(SerialNumber)) {
	        machineParts.remove(SerialNumber);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public boolean deleteMachine(String machineSerialNumber) {
	    if (machines.containsKey(machineSerialNumber)) {
	        machines.remove(machineSerialNumber);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	

}


