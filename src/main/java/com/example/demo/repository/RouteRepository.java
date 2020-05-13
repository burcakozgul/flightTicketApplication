package com.example.demo.repository;

import com.example.demo.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    @Override
    boolean existsById(Long id);
    boolean existsByRouteCode(String routeCode);
    boolean findByRouteCode(String routeCode);
}
