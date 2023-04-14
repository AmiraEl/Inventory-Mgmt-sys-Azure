package com.examples.applogic;

import java.util.List;

import com.examples.db.MachineDatabase;

public class MachineService {
	
	private MachineDatabase machineDatabase;
	public MachineService() {
		machineDatabase=new MachineDatabase();
	}
	public Machine getMachine(String serialNumber) {
		return machineDatabase.getMachine(serialNumber);
	}
	public MachinePart getMachinePart(String serialNumber) {
		return machineDatabase.getMachinePart(serialNumber);
	}
	public List<MachinePart> getMachineParts(){
		return machineDatabase.getMachineParts();
	}
	public List<Machine> getAllMachines(){
		return machineDatabase.getMachines();
	}
	
	public List<Machine> searchMachineByType(String type){
		return machineDatabase.searchMachineByType(type);
	}
	
	public List<MachinePart> searchMachinePartByMachineSerialNum(String serialNum){
		return machineDatabase.searchMachinePartByMachineSerialNum(serialNum);
	}
	public List<String> getMachineTypes(){
		return machineDatabase.getMachineTypes();
	}
	
	public List<Integer> getMachinePartTypeIDs(){
		return machineDatabase.getMachinePartTypeIDs();
	}
	public Machine addMachine(Machine machine) {
		return machineDatabase.addMachine(machine);
	}
	
	
	public MachinePart addMachinePart(MachinePart machinePart) {
		return machineDatabase.addMachinePart(machinePart);
	}
	
	public Machine updateMachine(Machine machine) {
		return machineDatabase.updateMachine(machine);
	}
	public MachinePart updateMachinePart(MachinePart machinePart) {
		return machineDatabase.updateMachinePart(machinePart);
	}
	
	public boolean deleteMachine(String serialNumber) {
		return machineDatabase.deleteMachine(serialNumber);
	}
	
	public boolean deleteMachinePart(String SerialNumber) {
	    return machineDatabase.deleteMachinePart(SerialNumber);
	}
	
	
	

}
