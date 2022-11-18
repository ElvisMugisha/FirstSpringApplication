package com.example.demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carAPI")
public class CarController {
    private final CarService carService;
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
    }


    // Home Page
    @GetMapping("/")
    public String welcome() {
        return "Hello Elvis, Welcome to your Car collection!";
    }

    // Get all cars
    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    // Get car by name
    @GetMapping("/car/{name}")
    public Car getCarByName(@PathVariable(value = "name") String name) {
        return carRepository.findByName(name);

    }

    // Create new car
    @PostMapping("/car/addNewCar")
    @ResponseStatus(HttpStatus.CREATED)
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // Delete car
    @DeleteMapping(path = "{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }

    // Update car
    @PutMapping("/car/{id}")
    public void updateCar(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color) {
        carService.updateCar(id, name, color);
    }

}
