package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MachineRepository extends JpaRepository<Machine, String> {

    @Query("SELECT m FROM Machine m")
    List<Machine> getAllMachines();

    @Query("SELECT m FROM Machine m WHERE m.machineSerialNumber = :serialNumber")
    Machine getMachineBySerialNumber(String serialNumber);

    @Query("SELECT m FROM Machine m WHERE m.machineType = :type")
    List<Machine> searchMachineByType(String type);

    @Modifying
    @Query("DELETE FROM Machine m WHERE m.machineSerialNumber = :serialNumber")
    void deleteMachine(String serialNumber);
    
    @Query("SELECT DISTINCT m.machineType FROM Machine m")
    List<String> getMachineTypes();
    
}
