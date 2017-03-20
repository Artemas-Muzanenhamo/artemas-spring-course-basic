package com.spring.lesson.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> list = new ArrayList<Topic>();
        topicRepository.findAll().forEach(list :: add);

        return list;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);

    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        for (int i=0; i<topics.size(); i++){
//
//            Topic t = topics.get(i);
//
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//
//        }

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {

        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.delete(id);
    }
}
