package com.examples.applogic;

import java.util.List;

import com.examples.db.MachineDatabase;

public class MachineService {
	
	
	public Machine getMachine(String serialNumber) {
		return MachineDatabase.getMachine(serialNumber);
	}
	public MachinePart getMachinePart(String serialNumber) {
		return MachineDatabase.getMachinePart(serialNumber);
	}
	public List<MachinePart> getMachineParts(){
		return MachineDatabase.getMachineParts();
	}
	public List<Machine> getAllMachines(){
		return MachineDatabase.getMachines();
	}
	
	public List<Machine> searchMachineByType(String type){
		return MachineDatabase.searchMachineByType(type);
	}
	
	public List<MachinePart> searchMachinePartByMachineSerialNum(String serialNum){
		return MachineDatabase.searchMachinePartByMachineSerialNum(serialNum);
	}
	public List<String> getMachineTypes(){
		return MachineDatabase.getMachineTypes();
	}
	
	public List<Integer> getMachinePartTypeIDs(){
		return MachineDatabase.getMachinePartTypeIDs();
	}
	public Machine addMachine(Machine machine) {
		return MachineDatabase.addMachine(machine);
	}
	
	
	public MachinePart addMachinePart(MachinePart machinePart) {
		return MachineDatabase.addMachinePart(machinePart);
	}
	
	public Machine updateMachine(Machine machine) {
		return MachineDatabase.updateMachine(machine);
	}
	public MachinePart updateMachinePart(MachinePart machinePart) {
		return MachineDatabase.updateMachinePart(machinePart);
	}
	
	public boolean deleteMachine(String serialNumber) {
		return MachineDatabase.deleteMachine(serialNumber);
	}
	
	public boolean deleteMachinePart(String SerialNumber) {
	    return MachineDatabase.deleteMachinePart(SerialNumber);
	}
	
	
	

}
