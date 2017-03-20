package com.spring.lesson.courses;

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
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        //return topics;
        List<Course> list = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(list :: add);

        return list;
    }

    public Course getCourse(String id){
        return courseRepository.findOne(id);

    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
