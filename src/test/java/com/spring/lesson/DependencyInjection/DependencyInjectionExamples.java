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
     * 1) Spring --> Create an instance of this Service (GoodMorningServiceImpl). => @Component
     * 2) Spring --> Needs to give the DependencyInjectionExamples the created GoodMorningServiceImpl instance. => @Autowired
     *
     * Autowire by Class
     * 2) Once Spring identifies the @Autowired Annotation
     * it searches through the list of Components in the
     * Spring IOC for the GoodMorningService bean exists.
     * If it exists Spring then instantiates the GoodMorningServiceImpl
     * in our DependencyInjectionExamples
     *
     * Autowire by Interface
     * 1) Instead of autowiring using our `Impl` Class Name we can
     * Autowire using the interface our `Impl` Class implements.
     *
     */
    @Autowired
    HiService service;

    @Test
    public void dummyTest(){

        System.out.println(service.sayHi());
    }

}


/**
 * Autowire by Class
 * 1) Spring looks for the Class GoodMorningServiceImpl
 *
 * Autowire by Interface
 * 2) When Spring detects that we are autowiring an Interface,
 * it will start to look for the implementations of our `HiService`.
 * In this case it will find the `GoodMorningServiceImpl` and it will
 * instantiate and return the instance to the `DependencyInjectionExamples`
 * Class.
 */
@Component
class GoodMorningServiceImpl implements HiService{

    @Override
    public String sayHi() {

        return "Good Morning";
    }

}

/**
 * WHAT IF THERE ARE TWO OR MORE CLASSES THAT IMPLEMENT THE SAME INTERFACE?
 */
@Component
class GoodNightServiceImpl implements HiService{

    @Override
    public String sayHi() {

        return "Good Night";
    }

}


