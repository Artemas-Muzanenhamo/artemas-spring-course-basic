package com.spring.lesson.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 16/03/2017.
 */

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(

                new Topic("spring", "Spring FrameWork", "this is a spring description"),
                new Topic("java", "Core Java", "this is a Java description"),
                new Topic("javascript", "Love Javascript", "this is a javascript description"),
                new Topic("python", "Python", "this is a python description")
        );
    }

}
