package com.example.demo.repository;

import com.example.demo.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    @Override
    boolean existsById(Long id);
}
