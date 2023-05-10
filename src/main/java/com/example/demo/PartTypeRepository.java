package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PartTypeRepository extends JpaRepository<PartType,Integer> {

	 @Query("SELECT h FROM PartType h")
	List<PartType> getallparttypes();
	
	
	 
	 @Modifying
	 @Query("delete from PartType h where h.id=:id")
	 void deletePartType(int id);
	 
	

	 @Query("SELECT h FROM PartType h WHERE h.id = :id")
	 PartType getPartTypeById(int id);

	 

	 @Query("SELECT h FROM PartType h WHERE h.supplierID = :supplierId")
	 List<PartType> searchPartTypeBySupplierId(int supplierId);
	
	 
	 
	 
	 

}
