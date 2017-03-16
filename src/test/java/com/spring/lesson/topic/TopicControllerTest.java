package com.spring.lesson.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by amuzanenhamo on 16/03/2017.
 *
 * @RunWith(SpringRunner.class) - JUnit will invoke the class it references to run the tests in that class instead of the runner built into JUnit.
 *
 * @SpringBootTest - Annotation that can be specified on a test class that runs Spring Boot based tests.
 *                   Provides the following features over and above the regular Spring TestContext Framework:
 *
 *                   Uses SpringBootContextLoader as the default ContextLoader when no specific @ContextConfiguration(loader=...) is defined.
 *                   Automatically searches for a @SpringBootConfiguration when nested @Configuration is not used, and no explicit classes are specified.
 *                   Allows custom Environment properties to be defined using the properties attribute.
 *                   Provides support for different webEnvironment modes, including the ability to start a fully running container listening on a defined or random port.
 *                   Registers a TestRestTemplate bean for use in web tests that are using a fully running container.
 *
 * @AutoConfigureMockMvc - Annotation that can be applied to a test class to enable and configure auto-configuration of MockMvc.
 *
 * NOTE: If you are going to using the `content().json()` method then you will need to make sure you have the:
 * "org.skyscreamer --> jsonassert" Loaded in the Classpath.
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTopics() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/topics").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\"id\":\"spring\",\"name\":\"Spring FrameWork\",\"description\":\"this is a spring description\"}," +
                        "{\"id\":\"java\",\"name\":\"Core Java\",\"description\":\"this is a Java description\"}," +
                        "{\"id\":\"javascript\",\"name\":\"Love Javascript\",\"description\":\"this is a javascript description\"}," +
                        "{\"id\":\"python\",\"name\":\"Python\",\"description\":\"this is a python description\"}" +
                        "]"));
    }
}
