package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/carController")
@Component
public class CarController {
    @Autowired
    CarRepository carRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @PostMapping(path="/postCar", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Car car){
        LOGGER.info("Came to post data for string" + car);
        Car car1= carRepository.save(car);
        return ResponseEntity.ok().body(
                "Hi - the generated id post saving object is "
                        + car.getId() + " With a name : " + car.getName()
        );
    }
}
