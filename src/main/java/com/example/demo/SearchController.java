package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/elvisSearch")
@Component
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @GetMapping(path="/getAllJavaTrainees",produces = "application/json")
    public ResponseEntity<Object> getSomeTrainees(HttpServletRequest request) throws Exception {

        LOGGER.info("came to getAllData");
        List<String> listOfJavaTrainees = returnDummyList();
        return ResponseEntity.ok().body(listOfJavaTrainees);

    }

    @GetMapping(path="/getAllJavaTrainees1",produces = "application/json")
    public ResponseEntity<Object> getSomeTrainees1(HttpServletRequest request) throws Exception {

        LOGGER.info("came to getAllData");
        List<String> listOfJavaTrainees = returnDummyList1();
        return ResponseEntity.ok().body(listOfJavaTrainees);

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
