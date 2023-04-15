package com.examples.applogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.examples.db.MachineDatabase;

public class MachineService {
	
	private InventoryService inventoryService;
	
	public MachineService() {
		inventoryService=new InventoryService();
	}
	
	
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
	
	public List<MachinePart> searchMachinePartByPartTypeID(int partTypeID){
		return MachineDatabase.searchMachinePartByPartTypeID(partTypeID);
	}
	
	public List<RequiredPart> getPartsToOrder(int daysAhead){
		List<RequiredPart> requiredParts=new ArrayList<>();
		
		List<PartType> partTypes=inventoryService.getPartTypes();
		
		for (PartType partType: partTypes) {
			RequiredPart requiredPart=new RequiredPart(partType, 0);
			
				
			List<MachinePart> machineParts=MachineDatabase.searchMachinePartByPartTypeID(partType.getPartTypeID());
				
			for(MachinePart machinePart: machineParts) {
				

					long daysLeft=partType.getLifetime() - Utils.daysFromDate(machinePart.getInstallationDate());
					daysLeft=daysLeft-partType.getExpectedDeliveryDuration();
					if (machinePart.isFaulty() || daysLeft<daysAhead) {
						boolean reservedPart=inventoryService.reserveSparePart(machinePart.getPartTypeID(), machinePart.getMachineSerialNumber());
						if (!reservedPart)
							requiredPart.incremetQuantity();
							
					}
					
			}
				
			if (requiredPart.getQuantity()>0)
				requiredParts.add(requiredPart);
		}
		
		
		
		
		
		
		return requiredParts;
	}
	
	
	

}
