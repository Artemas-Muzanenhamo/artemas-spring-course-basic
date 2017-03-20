package com.spring.lesson.courses;

import com.spring.lesson.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1. Create Our Rest Controller to direct requests to the right Method.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Get all Courses
     *
     * 2. Map Requests using the @{@link RequestMapping} Annotation.
     *
     * 3. If there are tokens in the url to be passed to a method,
     * you will need to use the @{@link PathVariable} annotation which
     * tells Spring to map the token and pass the token value to the
     * parameter in the Java Method.
     *
     * @return - List of all the Courses.
     */
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    /**
     * Get Topic by ID
     *
     * @param id - token passed in from the browser
     * @return - A Course matching the token {id}
     */
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    /**
     * Add a Topic in the List
     *
     * 4. Use different RequestMethods provided by the {@link RequestMethod} Enum.
     *
     * 5. By defining the RequestMethod we will need to also define the value which
     * is the requested path from the browser which will be mapped to this method.
     *
     * 6. Get the requestbody of any RequestMethod that requires use to store
     * information. In this case we would use the @{@link RequestBody} Annotation
     * to achieve this.
     *
     * @param topicId - the topic where the course will be added into
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
