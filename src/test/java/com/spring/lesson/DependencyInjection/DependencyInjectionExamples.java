package com.spring.lesson.DependencyInjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Who is creating Spring?
 *
 * - @RunWith(SpringJUnit4ClassRunner.class) This is what instantiates
 * the SpringFramework.
 *
 * - To be able to instantiate the SpringFramework
 * we will need to define the Application Context.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DependencyInjectionExamples {

    /**
     * 1) Spring --> Create an instance of this Service (GoodMorningService). => @Component
     * 2) Spring --> Needs to give the DependencyInjectionExamples the created GoodMorningService instance. => @Autowired
     */
    @Autowired
    GoodMorningService service;

    @Test
    public void dummyTest(){

        System.out.println(service.sayHi());
    }

}


/**
 * How Does Spring know To Search for this @Component or Beans ?
 *
 * - Spring will use the Component-scan where it will search
 * for Components or Beans under a specified Context. This Components
 * or Beans will exists in particular packages which will be scanned
 * depending IF they exist within the defined basePackage. In our case
 * we are telling Spring to Scan:
 *  @ComponentScan(basePackages = {"com.spring.lesson"})
 *  There Spring will Scan for our @Components or Beans declared.
 */
@Component
class GoodMorningService {

    public String sayHi() {

        return "Good Morning";
    }

}
