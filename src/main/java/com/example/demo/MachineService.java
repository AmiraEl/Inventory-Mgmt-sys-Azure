package com.example.demo;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.MachinePartRepository;
import com.example.demo.MachineRepository;
import com.example.demo.InventoryService;
import com.example.demo.PartType;


@Service
public class MachineService {
	
	@Autowired
	private MachineRepository machineRepository;
	
	@Autowired
	private MachinePartRepository machinePartRepository;
	

	
	List<PartType> getPartTypes() throws IOException, URISyntaxException {
	    // Build URI with parameters
	    URI uri = new URIBuilder("http://localhost:8080/inventory/part_types")
	            .build();

	    // Create HTTP GET request
	    HttpGet httpGet = new HttpGet(uri);

	    // Send HTTP GET request and get response
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

	    // Parse response JSON to PartType list
	    ObjectMapper objectMapper = new ObjectMapper();
	    PartType[] partTypesArray = objectMapper.readValue(httpResponse.getEntity().getContent(), PartType[].class);
        List<PartType> partTypes = Arrays.asList(partTypesArray);

	    // Close resources
	    httpResponse.close();
	    httpClient.close();

	    return partTypes;
	}
	
	
	public int reserveSpareParts(int partTypeID, String machineSerialNum, int quantityNeeded) throws IOException, URISyntaxException {
	    // Build request body map
	    Map<String, Object> requestBody = new HashMap<>();
	    requestBody.put("partTypeID", partTypeID);
	    requestBody.put("machineSerialNum", machineSerialNum);
	    requestBody.put("quantityNeeded", quantityNeeded);

		// Build URI with parameters
	    URI uri = new URIBuilder("http://localhost:8080/inventory/spare_parts_reservation")
	            .build();

	    // Create HTTP connection
	    HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json");
	    connection.setDoOutput(true);

	    // Write request body
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.writeValue(connection.getOutputStream(), requestBody);

	    // Read response
	    int responseCode = connection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        InputStream inputStream = connection.getInputStream();
	        int quantity = objectMapper.readValue(inputStream, Integer.class);
	        inputStream.close();
	        return quantity;
	    } else {
	        throw new IOException("HTTP error code: " + responseCode);
	    }
	}




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
	
	public List<RequiredPart> getPartsToOrder(int daysAhead) throws IOException, URISyntaxException{
		
		List<RequiredPart> requiredParts=new ArrayList<>();
		
		List<PartType> partTypes=getPartTypes();
		List<Machine> machines=machineRepository.findAll();
		
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
				
				
				
				counter=reserveSpareParts(partType.getId(), machine.getMachineSerialNumber(),counter );
				
				
				
				requiredPart.addToQuantity(counter);
				
				
				
			}	
			if (requiredPart.getQuantity()>0)
				requiredParts.add(requiredPart);
		}
		
		
		
		
		
		
		return requiredParts;
	}
	
}