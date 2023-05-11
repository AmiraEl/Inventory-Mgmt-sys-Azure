package com.example.machineservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SparePart {
    
    @Id
 
    private String serialNumber;
    
  
    private int partTypeID;
    
   
    private boolean reserved;
    
    
    private String reservedMachineSerialNum;

    public SparePart() {}
    
    public SparePart(String serialNumber, int partTypeID, boolean reserved, String reservedMachineSerialNum) {
        this.serialNumber = serialNumber;
        this.partTypeID = partTypeID;
        this.reserved = reserved;
        this.reservedMachineSerialNum = reservedMachineSerialNum;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPartTypeID() {
        return partTypeID;
    }

    public void setPartTypeID(int partTypeID) {
        this.partTypeID = partTypeID;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getReservedMachineSerialNum() {
        return reservedMachineSerialNum;
    }

    public void setReservedMachineSerialNum(String reservedMachineSerialNum) {
        this.reservedMachineSerialNum = reservedMachineSerialNum;
    }

    @Override
    public String toString() {
        return "SparePart [serialNumber=" + serialNumber + ", partTypeID=" + partTypeID + ", reserved=" + reserved
                + ", reservedMachineSerialNum=" + reservedMachineSerialNum + "]";
    }
}
