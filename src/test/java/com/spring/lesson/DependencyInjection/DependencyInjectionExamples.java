package com.spring.lesson.DependencyInjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * How does Spring do the matching using the @Componenet -> @Autowired known as Autowiring?
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DependencyInjectionExamples {

    /**
     * 1) Spring --> Create an instance of this Service (GoodMorningService). => @Component
     * 2) Spring --> Needs to give the DependencyInjectionExamples the created GoodMorningService instance. => @Autowired
     *
     * 2) Once Spring identifies the @Autowired Annotation
     * it searches through the list of Components in the
     * Spring IOC for the GoodMorningService bean exists.
     * If it exists Spring then instantiates the GoodMorningService
     * in our DependencyInjectionExamples
     */
    @Autowired
    GoodMorningService service;

    @Test
    public void dummyTest(){

        System.out.println(service.sayHi());
    }

}


/**
 * 1) Spring looks for the Class GoodMorningService
 */
@Component
class GoodMorningService {

    public String sayHi() {

        return "Good Morning";
    }

}
