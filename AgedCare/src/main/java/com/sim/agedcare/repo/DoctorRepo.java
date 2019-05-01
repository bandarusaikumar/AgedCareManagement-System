package com.sim.agedcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.agedcare.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}
