package com.harrylee.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harrylee
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {


    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/name")
    public String helloName(String name) {
        return "Hello " + name;
    }

}
