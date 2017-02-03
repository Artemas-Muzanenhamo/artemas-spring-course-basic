package com.spring.lesson.DependencyInjection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Typically we would do write:
 *
 * GoodMorningService service = new GoodMorningService();
 *
 * Since we don't want to create the Dependency by instantiating it,
 * we have to let Spring handle that dependency.
 *
 * HOW?
 *
 * Spring Inversion of Control (IOC) Container.
 * - Takes care of creating the beans that
 * are needed.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DependencyInjectionExamples {

    /**
     * So what bean do we need?
     *
     * We need the `service` bean. In such case,
     * we would want to be able to create the bean
     * and we would want to be able to use it in
     * this particular example.
     *
     * So we would need to tell Spring two things:
     *
     * 1) Spring --> Create an instance of this Service (GoodMorningService). => @Component
     * 2) Spring --> Needs to give the DependencyInjectionExamples the created GoodMorningService instance. => @Autowired
     *
     * In this case `service` is the bean thus Spring will need to
     * manage the bean for us than us handling the bean manually.
     * So Spring needs to:
     *
     * 1) Manage the `service Bean`
     * 2) Be able to provide the bean to the DependencyInjectionExamples when needed.
     * 3) Destroy the bean once the DependencyInjectionExamples Class is done/finished.
     *
     */
    @Autowired
    GoodMorningService service;

    @Test
    public void dummyTest(){

        System.out.println(service.sayHi());
    }

}


/**
 *  - So How do we tell Spring to create an instance
 * of the GoodMorningService?
 *
 * Firstly we would need to put an annotation
 * `@Component` on the Class.
 *
 * By using the @Component annotation, we are telling
 * Spring that it will handle this Dependency. In
 * other words, we are saying that the Object
 * GoodMorningService is managed the Spring IOC.
 *
 *  - So How do we tell Spring to `INJECT` this
 *  dependency? How does Spring know that?
 *
 *  We do this by using the @Autowired annotation
 *  on the Class that would want to use this dependency.
 */
@Component
class GoodMorningService {

    public String sayHi() {

        return "Good Morning";
    }

}
