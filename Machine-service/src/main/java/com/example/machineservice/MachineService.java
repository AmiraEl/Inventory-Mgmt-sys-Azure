package com.example.machineservice;

import com.example.machineservice.InventoryService;
import com.example.machineservice.PartType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineService {
	
	@Autowired
	private MachineRepository machineRepository;
	
	@Autowired
	private MachinePartRepository machinePartRepository;
	
	@Autowired
	private InventoryService inventoryService;

	public Machine getMachine(String serialNumber) {
		return machineRepository.getMachineBySerialNumber(serialNumber);
	}
	
	public MachinePart getMachinePart(String serialNumber) {
		return machinePartRepository.getMachinePartBySerialNumber(serialNumber);
	}
	
	public List<MachinePart> getMachineParts(){
		return machinePartRepository.findAll();
	}
	
	public List<Machine> getAllMachines(){
		return machineRepository.findAll();
	}
	
	public List<Machine> searchMachineByType(String type){
		return machineRepository.searchMachineByType(type);
	}
	
	public List<MachinePart> searchMachinePartByMachineSerialNum(String serialNum){
		return machinePartRepository.searchMachinePartByMachineSerialNumber(serialNum);
	}
	
	public List<String> getMachineTypes(){
		return machineRepository.getMachineTypes();
	}
	
	public List<Integer> getMachinePartTypeIDs(){
		return machinePartRepository.getMachinePartTypeIDs();
	}
	
	public Machine addMachine(Machine machine) {
		return machineRepository.save(machine);
	}
	
	public MachinePart addMachinePart(MachinePart machinePart) {
		return machinePartRepository.save(machinePart);
	}
	
	public Machine updateMachine(Machine machine) {
		return machineRepository.save(machine);
	}
	
	public MachinePart updateMachinePart(MachinePart machinePart) {
		return machinePartRepository.save(machinePart);
	}
	
	public boolean deleteMachine(String serialNumber) {
		machineRepository.deleteMachine(serialNumber);
		return true;
	}
	
	public boolean deleteMachinePart(String serialNumber) {
	    machinePartRepository.deleteMachinePart(serialNumber);
	    return true;
	}
	
	public List<MachinePart> searchMachinePartByPartTypeID(int partTypeID){
		return machinePartRepository.searchMachinePartByPartTypeID(partTypeID);
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
		
		List<PartType> partTypes=inventoryService.getAllPartTypes();
		List<Machine> machines=this.getAllMachines();
		for (PartType partType: partTypes) {
			RequiredPart requiredPart=new RequiredPart(partType, 0);
			
				
			List<MachinePart> machineParts=machinePartRepository.searchMachinePartByPartTypeID(partType.getId());
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
				counter-=inventoryService.reserveSpareParts(partType.getId(), machine.getMachineSerialNumber(),counter );
				requiredPart.addToQuantity(counter);
				
			}	
			if (requiredPart.getQuantity()>0)
				requiredParts.add(requiredPart);
		}
		
		
		
		
		
		
		return requiredParts;
	}
	
}