package com.angelinux.coredemo.config;


import com.angelinux.coredemo.common.Coach;
import com.angelinux.coredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
