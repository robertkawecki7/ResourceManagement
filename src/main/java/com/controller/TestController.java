package com.controller;

import com.view.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
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
