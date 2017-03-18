package com.spring.lesson.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by amuzanenhamo on 16/03/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

//    @Autowired
//    private Topic topic;

    @Test
    public void getAllTopics() {

        List<Topic> actual = Arrays.asList(
                new Topic("spring", "Spring FrameWork", "this is a spring description"),
                new Topic("java", "Core Java", "this is a Java description"),
                new Topic("javascript", "Love Javascript", "this is a javascript description"),
                new Topic("python", "Python", "this is a python description")
        );

//        List<Topic> actual = Arrays.asList(
//                new Topic("spring", "Spring FrameWork", "this is a spring description"),
//                new Topic("java", "Core Java", "this is a Java description"),
//                new Topic("javascript", "Love Javascript", "this is a javascript description"),
//                new Topic("python", "Python", "this is a python description"),
//                new Topic("golang", "GoLang", "Language on the rise")
//        );

        assertThat(topicService.getAllTopics().size(), is(actual.size()));
    }

//    @Test
//    public void addTopic(){
//
//
//
//        Topic sample = new Topic();
//
//        sample.setId("golang");
//        sample.setName("Go Lang");
//        sample.setDescription("This language is coming up fast");
//
//
//        topicService.addTopic(sample);
//
//        assertThat(topicService.getAllTopics().size(), is(5));
//
//    }
}
