package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="spare_part")
@Data
public class SparePart {
    
    @Id
    private String serialNumber;
    
    @Column(name="part_type_id")
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
