package com.angelinux.coredemo.rest;

import com.angelinux.coredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    // Annotation tells Spring inject dependency using this Constructor
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) { // Class which implements Coach Interface
        // Default scope is singleton: both fields refer to the same bean
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/comparebeans")
    public String checkbeans() {
        return "Comparing beans: myCoach == anotherCoach -> " + (myCoach == anotherCoach);
    }
}
