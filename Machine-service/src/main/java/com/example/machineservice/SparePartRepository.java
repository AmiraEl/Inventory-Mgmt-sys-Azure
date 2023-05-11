package com.example.machineservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SparePartRepository extends JpaRepository<SparePart, String> {

    @Query("SELECT s FROM SparePart s")
    List<SparePart> getAllSpareParts();

    @Query("SELECT s FROM SparePart s WHERE s.serialNumber = :serialNumber")
    SparePart getSparePartBySerialNumber(String serialNumber);

    
    @Query("SELECT s FROM SparePart s WHERE s.partTypeID = :partTypeID")
    List<SparePart> searchSparePartByPartTypeID(int partTypeID);

   
    @Modifying
    @Query("DELETE FROM SparePart s WHERE s.serialNumber = :serialNumber")
    void deleteSparePart(String serialNumber);
}
