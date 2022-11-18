package com.example.demo.wordMeaning;

import com.example.demo.car.Car;
import com.example.demo.car.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/elvisSearch")
@Component
public class SearchController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    WordMeaningRepository wordMeaningRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @GetMapping(path="/getAllJavaTrainees",produces = "application/json")
    public ResponseEntity<Object> getSomeTrainees(HttpServletRequest request) {

        LOGGER.info("came to getAllData");
        List<String> listOfJavaTrainees = returnDummyList();
        return ResponseEntity.ok().body(listOfJavaTrainees);

    }

    @GetMapping(path="/getAllJavaTrainees1",produces = "application/json")
    public ResponseEntity<Object> getSomeTrainees1(HttpServletRequest request) {

        LOGGER.info("came to getAllData1");
        List<String> listOfJavaTrainees1 = returnDummyList1();
        return ResponseEntity.ok().body(listOfJavaTrainees1);

    }

    @PostMapping(path="/postAllJavaTrainees", produces = "application/json")
    public ResponseEntity<Object> postAllJavaTrainees(@RequestBody String inputString){

        LOGGER.info("came to post data for string" + inputString);
        List<String> randomStrings = returnPostDummyList(inputString);
        return ResponseEntity.ok().body(randomStrings);
    }

    @PostMapping(path="/postAllJavaTrainees1", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Object inputString){

        LOGGER.info("came to post data for string" + inputString);
        List<String> randomStrings = returnDummyList1();
        return ResponseEntity.ok().body(randomStrings);
    }

    @PostMapping(path="/postDog", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Dog dog){
        LOGGER.info("came to post data for string" + dog);
        if(dog.getColor().equals("red")){
            return ResponseEntity.ok().body("Hi - " + dog.getName());
        }
        else{
            return ResponseEntity.ok().body("No hi to you, not red dog - " + dog.getName() + " Dog of color : " + dog.getColor());
        }
    }

    @PostMapping(path="/postWord", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody WordMeaning wordMeaning){
        LOGGER.info("Came to post data for string" + wordMeaning);
        WordMeaning wordMeaning1= wordMeaningRepository.save(wordMeaning);
        return ResponseEntity.ok().body(
                "Hi - the generated id post saving object is "
                + wordMeaning.getId() + " With a word : " + wordMeaning.getWord()
        );
    }

    @PostMapping(path="/postCar", produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody Car car) {
        LOGGER.info("Came to post Car info!" + car);
        Car car1 = carRepository.save(car);
        return ResponseEntity.ok().body(
                "Hello, your car detailed info was created successful!:  CarName " + car.getName()
        );
    }

    private List<String> returnPostDummyList(String inputString) {
        List<String> list = new ArrayList<String>();
        list.add(inputString);
        return list;
    }

    private List<String> returnDummyList() {
        List<String> list = new ArrayList<String>();
        list.add("Elvis");
        list.add("Ernest");
        list.add("Phase");
        list.add("Innocent");
        return list;
    }

    private List<String> returnDummyList1() {
        List<String> list = new ArrayList<String>();
        list.add("Elvis1");
        list.add("Ernest1");
        list.add("Phase1");
        list.add("Innocent1");
        return list;
    }
}
