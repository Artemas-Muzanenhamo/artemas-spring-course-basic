package com.spring.lesson.courses;

import com.spring.lesson.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by amuzanenhamo on 16/03/2017.
 *
 * We need to map this object to become columns and rows in the relational DB.
 *
 * https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 */

@Entity // 12. This tells Hibernate to make a table out of this class
public class Course {

    @Id
    private String id; // 13. Mark as id in the relational DB.
    private String name;
    private String description;

    @ManyToOne
    private Topic topic; // 14. Tell Spring-Data that this is a foreign key. Many-to-One

    public Course() {}

    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
