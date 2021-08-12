package com.davy.poc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${some.config}")
    private String welcomeMessage;

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloworld() {
        return welcomeMessage;
    }

}
