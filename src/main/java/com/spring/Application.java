package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application Config
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //Bootstrap Springboot Application...
        SpringApplication.run(Application.class, args);
    }

}