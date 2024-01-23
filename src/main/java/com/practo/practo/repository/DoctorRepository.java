package com.practo.practo.repository;

import com.practo.practo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d From Doctor d WHERE d.name LIKE %:search% OR d.specialization LIKE %:search%")
    List<Doctor> searchByNameOrSpecialization(@Param("search") String search);
}

