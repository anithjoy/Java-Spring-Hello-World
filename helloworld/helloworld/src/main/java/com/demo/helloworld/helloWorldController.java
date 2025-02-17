package com.demo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/")
    public String home() {
        return "Hello Home";
    }

    @GetMapping("/gai")
    public String helloGai () {
        return "I love you Gai";
    }
}
