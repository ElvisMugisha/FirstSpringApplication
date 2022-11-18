package com.example.demo.car;

import com.example.demo.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);

    @Query
    Optional<Car> findCarByName(String name);

//    @Query("SELECT c FROM Car c WHERE c.color = ?1 ")
    Optional<Car> findCarByColor(String color);

    void deleteById(Long id);
}
