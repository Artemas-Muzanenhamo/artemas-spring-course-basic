package com.spring.lesson.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amuzanenhamo on 16/03/2017.
 */

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * Get all Topics
     * @return
     */
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    /**
     * Get Topic by ID
     * @param id
     * @return - Topic with the passed token {id}
     */
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    /**
     * Add a Topic in the List
     * @param topic
     */
    @RequestMapping(method=RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    /**
     * Update a Topic in the List
     * @param topic
     */
    @RequestMapping(method=RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
