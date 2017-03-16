package com.spring.lesson.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 16/03/2017.
 *
 * @Service - Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003)
 * as "an operation offered as an interface that stands alone in the model, with no encapsulated state."

 */

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(

            new Topic("spring", "Spring FrameWork", "this is a spring description"),
            new Topic("java", "Core Java", "this is a Java description"),
            new Topic("javascript", "Love Javascript", "this is a javascript description"),
            new Topic("python", "Python", "this is a python description")
    );

    public List<Topic> getAllTopics(){
        return topics;
    }
}
