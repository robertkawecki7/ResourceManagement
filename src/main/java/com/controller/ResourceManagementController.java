package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger((ResourceManagementController.class));

    @RequestMapping("/test")
    public String home(){
        LOGGER.info("WORKS");
        return "Hello World!!";
    }

    @RequestMapping("/test/{value}")
    public String home(@PathVariable String value){
        LOGGER.info("WORKS: " + value);
        return "Hello World!!<br>" + value;
    }
}
