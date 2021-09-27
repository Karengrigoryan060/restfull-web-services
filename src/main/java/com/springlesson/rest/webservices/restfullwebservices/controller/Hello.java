package com.springlesson.rest.webservices.restfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {


    @GetMapping("/hello")
    public String test() {
        return new String("Hello");
    }

}
