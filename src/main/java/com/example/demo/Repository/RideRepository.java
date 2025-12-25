package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByStatus(String status); 

}
