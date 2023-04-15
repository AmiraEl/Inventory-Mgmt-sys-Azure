package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.applogic.InventoryService;
import com.examples.applogic.PartType;

import com.examples.applogic.SparePart;



@RestController
@RequestMapping("/inventory")
public class InventoryController {
	private InventoryService inventoryService;
	
	
	public InventoryController() {
		inventoryService=new InventoryService();
	}
	
	@PostMapping(path="part_types")
	public PartType addPartType(@RequestBody PartType partType) {
		
	
		return inventoryService.addPartType(partType);
	}
	
	@GetMapping(path="part_types")
	public List<PartType> getPartTypes(){
		return inventoryService.getPartTypes();
	}
	
	
	@GetMapping(path="part_types/{partTypeID}")
	public PartType getPartType(@PathVariable("partTypeID")int partTypeID){
		return inventoryService.getPartType(partTypeID);
	}
	
	@GetMapping(path="part_types/supplier/{supplierID}")
	public List<PartType> searchPartTypeBySupplierID(@PathVariable("supplierID") int supplierID) {
	    return inventoryService.searchPartTypeBySupplierID(supplierID);
	}
	
	@PutMapping(path="part_types/{partTypeID}")
	public String updatePartType(@PathVariable("partTypeID")int partTypeID, @RequestBody PartType partType) {
		
		partType.setPartTypeID(partTypeID);
		PartType updatedPartType=inventoryService.updatePartType(partType);
		if (updatedPartType==null)
			return "part type doesn't exist";
		else return updatedPartType.toString();
	}
	
	@DeleteMapping(path="part_types/{partTypeID}")
	public String deletePartType(@PathVariable("partTypeID")int partTypeID) {
		if (inventoryService.deletePartType(partTypeID))
			return "Deleted";
		else return "Part Type doesnt exist";
	}
	@GetMapping(path="spare_parts")
	public List<SparePart> getSpareParts() {
	    return inventoryService.getSpareParts();
	}
	
	@GetMapping(path="spare_parts/{serialNum}")
	public SparePart getSparePart(@PathVariable("serialNum")String serialNum) {
		return inventoryService.getSparePart(serialNum);
	}
	@PostMapping(path="spare_parts")
	public String addSparePart(@RequestBody SparePart sparePart) {
		
		SparePart addedSparePart=inventoryService.addSparePart(sparePart);
		if (addedSparePart==null)
			return "Spare Part already exists";
		else return addedSparePart.toString();
		
	}
	
	@GetMapping(path="spare_parts/part_type/{partTypeID}")
	public List<SparePart> searchSparePartByPartTypeID(@PathVariable("partTypeID")int partTypeID) {
	    return inventoryService.searchSparePartByPartTypeID(partTypeID);
	}
	
	
	@PutMapping(path="spare_parts/{serialNum}")
	public String updateSparePart(@PathVariable("serialNum") String serialNum, @RequestBody SparePart sparePart) {
		
		if (!sparePart.getSerialNumber().equals(serialNum))
			return "can't change serial number";
		
		SparePart updatedSparePart=inventoryService.updateSparePart(sparePart);
		if (updatedSparePart==null)
			return "spare part doesn't exist";
		else return updatedSparePart.toString();
			
	}
	@DeleteMapping(path="spare_parts/{serialNum}")
	public String deleteSparePart(@PathVariable("serialNum")String serialNum) {
		if (inventoryService.deleteSparePart(serialNum))
			return "Deleted";
		else return "Spare part doesn't exist";
	}
	
	
}
