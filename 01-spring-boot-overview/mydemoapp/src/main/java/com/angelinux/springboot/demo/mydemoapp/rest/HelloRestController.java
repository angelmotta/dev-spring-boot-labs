package com.angelinux.springboot.demo.mydemoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @Value("${dev.name}")
    private String devName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Dev: " + devName + ", Team:" + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello world!";
    }


}
