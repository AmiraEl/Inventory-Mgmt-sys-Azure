package com.examples.applogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.db.MachineDatabase;


@Service
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
	
	
	public List<MachinePart> searchMachinePartByMachineSerialNumFromList(String serialNum, List <MachinePart>machineParts) {
	    List<MachinePart> matchingMachineParts = new ArrayList<>();
	    for (MachinePart machinePart : machineParts) {
	        if (machinePart.getMachineSerialNumber().equals(serialNum)) {
	            matchingMachineParts.add(machinePart);
	        }
	    }
	    return matchingMachineParts;
	}
	public List<RequiredPart> getPartsToOrder(int daysAhead){
		List<RequiredPart> requiredParts=new ArrayList<>();
		
		List<PartType> partTypes=inventoryService.getPartTypes();
		List<Machine> machines=this.getAllMachines();
		for (PartType partType: partTypes) {
			RequiredPart requiredPart=new RequiredPart(partType, 0);
			
				
			List<MachinePart> machineParts=MachineDatabase.searchMachinePartByPartTypeID(partType.getPartTypeID());
			for (Machine machine : machines) {
				List<MachinePart> machinePartsOfMachine=this.searchMachinePartByMachineSerialNumFromList(machine.getMachineSerialNumber(), machineParts);
				int counter=0;
				for(MachinePart machinePart: machinePartsOfMachine) {
					

					long daysLeft=partType.getLifetime() - Utils.daysFromDate(machinePart.getInstallationDate());
					daysLeft=daysLeft-partType.getExpectedDeliveryDuration();
					if (machinePart.isFaulty() || daysLeft<daysAhead) {
						counter+=1;
							
					}
					
				}
				counter-=inventoryService.reserveSpareParts(partType.getPartTypeID(), machine.getMachineSerialNumber(),counter );
				requiredPart.addToQuantity(counter);
				
			}	
			if (requiredPart.getQuantity()>0)
				requiredParts.add(requiredPart);
		}
		
		
		
		
		
		
		return requiredParts;
	}
	
	
	

}
