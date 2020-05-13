package com.example.demo.repository;

import com.example.demo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Override
    boolean existsById(Long id);

    @Modifying
    @Query(value = "UPDATE Flight SET availableSeat=availableSeat-1 where id=:id")
    void updateAvailableSeat(@Param("id") long id);

}
