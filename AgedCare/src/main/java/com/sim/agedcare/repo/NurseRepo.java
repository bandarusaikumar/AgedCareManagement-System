package com.sim.agedcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.agedcare.entity.Nurse;

public interface NurseRepo extends JpaRepository<Nurse, Long> {

}
