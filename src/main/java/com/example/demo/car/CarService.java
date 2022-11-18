package com.example.demo.car;

import com.example.demo.car.Car;
import com.example.demo.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        Optional<Car> carByName = carRepository.findCarByName(car.getName());

        if (carByName.isPresent()) {
            throw new IllegalStateException("Car Taken");
        }
        carRepository.save(car);
        System.out.println(car);
    }

    public void deleteCar(Long id) {
        boolean exists = carRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Car with Id " + id + " does not exists!");
        }
        carRepository.deleteById(id);
    }

    @Transactional
    public void updateCar(Long id, String name, String color) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Car with id " + id + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(car.getName(), name)) {
            car.setName(name);
        }

        if (color != null && color.length() > 0 && !Objects.equals(car.getColor(), color)) {
            Optional<Car> carByColor = carRepository.findCarByColor(color);

            if (carByColor.isPresent()) {
                throw new IllegalStateException("Color taken!");
            }
            car.setColor(color);
        }
    }
}
