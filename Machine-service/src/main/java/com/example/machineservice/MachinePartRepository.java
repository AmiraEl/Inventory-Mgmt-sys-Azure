package com.example.machineservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MachinePartRepository extends JpaRepository<MachinePart, String> {

    @Query("SELECT mp FROM MachinePart mp")
    List<MachinePart> getAllMachineParts();

    @Query("SELECT mp FROM MachinePart mp WHERE mp.serialNumber = :serialNumber")
    MachinePart getMachinePartBySerialNumber(String serialNumber);

    @Query("SELECT mp FROM MachinePart mp WHERE mp.machineSerialNumber = :machineSerialNumber")
    List<MachinePart> searchMachinePartByMachineSerialNum(String machineSerialNumber);

    @Query(value = "SELECT * FROM MachinePart WHERE part_type_id = :partTypeID", nativeQuery = true)
    List<MachinePart> searchMachinePartByPartTypeID(int partTypeID);

    @Modifying
    @Query("DELETE FROM MachinePart mp WHERE mp.serialNumber = :serialNumber")
    void deleteMachinePart(String serialNumber);
    
    @Query(value="SELECT DISTINCT mp.partTypeID FROM MachinePart mp", nativeQuery = true)
    List<Integer> getMachinePartTypeIDs();

    @Query("SELECT mp FROM MachinePart mp WHERE mp.machineSerialNumber = :serialNumber")
    List<MachinePart> searchMachinePartByMachineSerialNumber(String serialNumber);

}
