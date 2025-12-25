package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.RideRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entites.Ride;

@RestController
@RequestMapping("/api/rides")
@CrossOrigin(origins = "http://localhost:3000")
public class RideController {

    @Autowired
    private RideRepository rideRepository;

  

    @GetMapping("/available")
    public List<Ride> getAvailableRides() {
        return rideRepository.findByStatus("REQUESTED");
    }

    @PutMapping("/{id}/accept")
    public Ride acceptRide(@PathVariable Long id) {
        Ride ride = rideRepository.findById(id).orElseThrow();
        ride.setStatus("ACCEPTED");
        return rideRepository.save(ride);
    }

   
}

