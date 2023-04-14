package com.examples.applogic;

import java.util.Date;
import java.text.ParseException;

public class MachinePart {
	private String serialNumber;
	private int partTypeID;
	private Date installationDate;
	private String machineSerialNumber;
	private boolean faulty;
	
    public MachinePart(String serialNumber, int partTypeID, String installationDate, boolean faulty, String machineSerialNumber) throws ParseException {
        this.serialNumber = serialNumber;
        this.partTypeID = partTypeID;
        this.installationDate = (Date) Utils.parseDate(installationDate, "yyyy-MM-dd");
        this.faulty = faulty;
        this.machineSerialNumber=machineSerialNumber;
    }
    
    
    
    
    
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public String getMachineSerialNumber() {
        return machineSerialNumber;
    }

    public void setMachineSerialNumber(String serialNumber) {
        this.machineSerialNumber = serialNumber;
    }

    public int getPartTypeID() {
        return partTypeID;
    }

    public void setPartTypeID(int partTypeID) {
        this.partTypeID = partTypeID;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public boolean isFaulty() {
        return faulty;
    }

    public void setFaulty(boolean faulty) {
        this.faulty = faulty;
    }
    
    public String toString() {
        return "Serial Number: " + serialNumber + "\n"
               + "Part Type ID: " + partTypeID + "\n"
               + "Installation Date: " + installationDate + "\n"
               + "Faulty: " + faulty + "\n"
               + "Machine Serial Number: " + machineSerialNumber + "\n";
    }
	
	
}
