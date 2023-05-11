package com.example.demo;

import java.util.Date;

import lombok.Data;

import java.text.ParseException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.text.ParseException;


@Entity
@Data
@Table(name="machinepart")
public class MachinePart {

    @Id
    private String serialNumber;

    @Column(name="part_type_id")
    private int partTypeID;

    
    private Date installationDate;

    
    private String machineSerialNumber;

    private boolean faulty;

    public MachinePart() {
        // Required by JPA
    }

    public MachinePart(String serialNumber, int partTypeId, Date installationDate, boolean faulty, String machineSerialNumber) {
        this.serialNumber = serialNumber;
        this.partTypeID=partTypeId;
        this.installationDate = installationDate;
        this.faulty = faulty;
        this.machineSerialNumber = machineSerialNumber;
    }

    // Getters and setters

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPartTypeID() {
        return partTypeID;
    }

    public void setPartTypeID(int id) {
        this.partTypeID = id;
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

    public String getMachineSerialNumber() {
        return machineSerialNumber;
    }

    public void setMachineSerialNumber(String machineSerialNumber) {
        this.machineSerialNumber = machineSerialNumber;
    }

    public String toString() {
        return "Serial Number: " + serialNumber + "\n"
                + "Part Type ID: " + partTypeID + "\n"
                + "Installation Date: " + installationDate + "\n"
                + "Faulty: " + faulty + "\n"
                + "Machine Serial Number: " + machineSerialNumber + "\n";
    }
}
