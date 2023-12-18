package com.angelinux.coredemo.rest;

import com.angelinux.coredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    // Annotation tells Spring inject dependency using this Constructor
    @Autowired
    public DemoController(Coach theCoach) { // Class which implements Coach Interface
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
