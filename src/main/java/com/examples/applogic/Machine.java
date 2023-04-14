package com.examples.applogic;

public class Machine {
	
	private String machineSerialNumber;
	private String machineType;
	
	
	public Machine() {
		
	}
	
	public Machine(String machineSerialNumber, String machineType) {
		this.machineSerialNumber = machineSerialNumber;
		this.machineType = machineType;
	}
	
	

	public String getMachineSerialNumber() {
		return machineSerialNumber;
	}
	
	public String getMachineType() {
		return machineType;
	}
	
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	
	public void setMachineSerialNumber(String machineSerialNumber) {
		this.machineSerialNumber = machineSerialNumber;
	}
	
	public String toString() {
		return "\nMachine Serial Number: " + machineSerialNumber + "\nMachine Type: " + machineType + "\n";
	}

}
