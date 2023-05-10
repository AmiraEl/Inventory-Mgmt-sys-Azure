package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machines")
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	
	@GetMapping
	public List<Machine> getMachines(){
		return machineService.getAllMachines();
		
	}
	
	@GetMapping(path="parts")
	public List<MachinePart> getMachineParts(){
		return machineService.getMachineParts();
		
	}
	
	@GetMapping(path="parts/{partSerialNumber}")
	public MachinePart getMachinePart(@PathVariable("partSerialNumber")String serialNumber) {
		return machineService.getMachinePart(serialNumber);
	}
	
	
	
	@GetMapping(path="{machineSerialNumber}")
	public Machine getMachine(@PathVariable("machineSerialNumber") String machineSerialNumber){
		return machineService.getMachine(machineSerialNumber);
	}
	
	
	@GetMapping(path="types/{machineType}")
	public List<Machine> searchMachineByType(@PathVariable("machineType") String machineType){
		return machineService.searchMachineByType(machineType);
		
	}
	
	@GetMapping(path="types")
	public List<String> getMachineTypes(){
		return machineService.getMachineTypes();
	}
	@PostMapping
	public String addMachine(@RequestBody Machine machine) {
		
		Machine MachineAdded= machineService.addMachine(machine);
		
		if (MachineAdded==null)
			return "Machine already exists";
		else return MachineAdded.toString();
		
	}
	@PostMapping(path="parts")
	public String addMachinePart(@RequestBody MachinePart machinePart) {
		MachinePart MachinePartAdded= machineService.addMachinePart(machinePart);
		
		if (MachinePartAdded==null)
			return "Machine Part already exists";
		else return MachinePartAdded.toString();
	}
	
	@PostMapping(path="{machineSerialNum}/parts")
	public MachinePart addMachinePart(@PathVariable("machineSerialNum") String machineSerialNum, @RequestBody MachinePart machinePart) {
		machinePart.setMachineSerialNumber(machineSerialNum);
		return machineService.addMachinePart(machinePart);
	}
	
	@GetMapping(path="{machineSerialNum}/parts")
	public List<MachinePart> searchMachinePartByMachineSerialNum(@PathVariable("machineSerialNum")String serialNum){
		return machineService.searchMachinePartByMachineSerialNum(serialNum);
		
	}
	
	
	@GetMapping(path="required_parts")
	public List<RequiredPart> getPartsToOrder(@RequestBody int daysAhead){
		
		
		return machineService.getPartsToOrder(daysAhead);
	}
	
	
	@PutMapping(path="{machineSerialNumber}")
	public String updateMachine(@PathVariable("machineSerialNumber") String machineSerialNumber, @RequestBody Machine machine) {
		
		if  (!machineSerialNumber.equals(machine.getMachineSerialNumber()))
			return "Can't change serial number";
		Machine updatedMachine=machineService.updateMachine(machine);
		if(updatedMachine==null) {
			return "This machine doesn't exist";
		}else return "Machine Updated!\n"+updatedMachine;
	}
	
	@PutMapping(path="parts/{SerialNumber}")
	public String updateMachinePart(@PathVariable("SerialNumber") String SerialNumber, @RequestBody MachinePart machinePart) {
		
		if  (!SerialNumber.equals(machinePart.getSerialNumber()))
			return "Can't change serial number";
		MachinePart updatedMachinePart=machineService.updateMachinePart(machinePart);
		if(updatedMachinePart==null) {
			return "This machine part doesn't exist";
		}else return "Machine Part Updated!\n"+updatedMachinePart;
	}
	
	@PutMapping(path="machine/{machineSerialNum}/parts/{SerialNumber}")
	public String updateMachinePart(@PathVariable("machineSerialNum") String machineSerialNum, @PathVariable("SerialNumber") String SerialNumber, @RequestBody MachinePart machinePart) {
		
		if  (!SerialNumber.equals(machinePart.getSerialNumber()))
			return "Can't change serial number";
		MachinePart updatedMachinePart=machineService.updateMachinePart(machinePart);
		if(updatedMachinePart==null) {
			return "This machine part doesn't exist";
		}else return "Machine Part Updated!\n"+updatedMachinePart;
	}
	@DeleteMapping(path="parts/{SerialNumber}")
	public String deleteMachinePart(@PathVariable("SerialNumber") String SerialNumber) {
		if (machineService.deleteMachinePart(SerialNumber))
			return "Machine Part Deleted";
		else return "Machine Part doesn't exist";
	}
	@DeleteMapping(path="machine/{machineSerialNum}/parts/{SerialNumber}")
	public String deleteMachinePart(@PathVariable("machineSerialNum") String machineSerialNum,
			@PathVariable("SerialNumber") String SerialNumber ) {
		if (machineService.deleteMachinePart(SerialNumber))
			return "Machine Part Deleted";
		else return "Machine Part doesn't exist";
	}
	

	
	@DeleteMapping(path="{machineSerialNumber}")
	public String deleteMachine(@PathVariable("machineSerialNumber") String machineSerialNumber) {
		if (machineService.deleteMachine(machineSerialNumber))
			return "Machine Deleted";
		else return "Machine doesn't exist";
	}
	
	
	
	
	
	
	

		
	

}
