package com.sim.agedcare.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sim.agedcare.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "select * from PATIENT a where a.PATIENT_NAME =:name", nativeQuery = true)
    Patient findByName(@Param("name") String name);
    
    @Query("select p from Patient p where patientName=:patientName and patientPassword=:patientPassword")
	Patient findPatient(@Param("patientName") String patientName, @Param("patientPassword") String patientPassword);
    
    @Query("select p from Patient p where patientName=:patientName and patientPassword=:patientPassword")
    Patient findByPatientNameAndPatientPassword(@Param("patientName") String patientName,@Param("patientPassword") String patientPassword) ;
}
