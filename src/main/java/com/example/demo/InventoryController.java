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
import com.examples.applogic.PartTypeRequest;
import com.examples.db.InventoryDatabase;


@RestController
@RequestMapping("/inventory")
public class InventoryController {
	private InventoryService inventoryService;
	
	
	public InventoryController() {
		inventoryService=new InventoryService();
	}
	
	@PostMapping(path="part_types")
	public PartType addPartType(@RequestBody PartTypeRequest partTypeRequest) {
		PartType partType=partTypeRequest.convert();
	
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
	public List<PartType> searcPartTypeBySupplierID(@PathVariable("supplierID") int supplierID) {
	    return inventoryService.searcPartTypeBySupplierID(supplierID);
	}
	
	@PutMapping(path="part_types/{partTypeID}")
	public String updatePartType(@PathVariable("partTypeID")int partTypeID, @RequestBody PartType partType) {
		
		if (partType.getPartTypeID()!=partTypeID)
			return "can't change part type ID";
		PartType updatedPartType=inventoryService.updatePartType(partType);
		if (updatedPartType==null)
			return "part type doesn't exist";
		else return updatedPartType.toString();
	}
	
	@DeleteMapping(path="part_types/{partTypeID}")
	public String deletePartType(@PathVariable("partTypeID")int partTypeID) {
		if (InventoryDatabase.deletePartType(partTypeID))
			return "Deleted";
		else return "Part Type doesnt exist";
	}
	
	
}
