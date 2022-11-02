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

    private List<String> returnDummyList() {
        List<String> list = new ArrayList<String>();
        list.add("Elvis");
        list.add("Ernest");
        list.add("Phase");
        list.add("Innocent");
        return list;
    }
}
