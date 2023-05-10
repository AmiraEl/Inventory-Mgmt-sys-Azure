package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Machine {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String machineSerialNumber;
    private String machineType;
    
    
    public Machine() {
        
    }
    
    public Machine(String machineSerialNumber, String machineType) {
        this.machineSerialNumber = machineSerialNumber;
        this.machineType = machineType;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
