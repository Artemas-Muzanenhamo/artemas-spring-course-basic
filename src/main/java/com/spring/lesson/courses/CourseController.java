package com.spring.lesson.courses;

import com.spring.lesson.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amuzanenhamo on 16/03/2017.
 */

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Get all Courses
     * @return
     */
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    /**
     * Get Topic by ID
     * @param id
     * @return - Topic with the passed token {id}
     */
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    /**
     * Add a Topic in the List
     * @param course
     */
    @RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    /**
     * Update a Topic in the List
     * @param course
     */
    @RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
