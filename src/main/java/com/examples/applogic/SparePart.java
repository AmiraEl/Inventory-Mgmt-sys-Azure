package com.examples.applogic;

public class SparePart {
	
	
	private String serialNumber;
	private int partTypeID;
	private boolean reserved;
	private String reservedMachineSerialNum;
	
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
