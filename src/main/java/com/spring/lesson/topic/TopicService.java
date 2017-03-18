package com.spring.lesson.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 16/03/2017.
 *
 * This Service lies in the Business Service Layer of the application.
 *
 * @Service - Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003)
 * as "an operation offered as an interface that stands alone in the model, with no encapsulated state."

 */

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(

            new Topic("spring", "Spring FrameWork", "this is a spring description"),
            new Topic("java", "Core Java", "this is a Java description"),
            new Topic("javascript", "Love Javascript", "this is a javascript description"),
            new Topic("python", "Python", "this is a python description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i=0; i<topics.size(); i++){

            Topic t = topics.get(i);

            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }

        }
    }

    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id));
//        for (int i=0; i<topics.size(); i++){
//
//            Topic t = topics.get(i);
//
//            if (t.getId().equals(id)){
//                topics.remove(i);
//                return;
//            }
//        }
    }
}
