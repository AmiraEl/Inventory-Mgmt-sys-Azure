package com.example.demo;

import java.util.Date;

import lombok.Data;

import java.text.ParseException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class MachinePart {

    @Id
    private String serialNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_type_id")
    private PartType partType;

    @Column(name = "installation_date")
    private Date installationDate;

    @Column(name = "machine_serial_number")
    private String machineSerialNumber;

    private boolean faulty;

    public MachinePart() {
        // Required by JPA
    }

    public MachinePart(String serialNumber, PartType partType, Date installationDate, boolean faulty, String machineSerialNumber) {
        this.serialNumber = serialNumber;
        this.partType = partType;
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

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
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
                + "Part Type: " + partType + "\n"
                + "Installation Date: " + installationDate + "\n"
                + "Faulty: " + faulty + "\n"
                + "Machine Serial Number: " + machineSerialNumber + "\n";
    }
}
