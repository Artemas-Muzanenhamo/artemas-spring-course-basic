package com.spring.lesson.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amuzanenhamo on 16/03/2017.
 *
 * This is a Controller
 *
 * @RestController - A convenience annotation that is itself annotated with @Controller and @ResponseBody.
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }

}
