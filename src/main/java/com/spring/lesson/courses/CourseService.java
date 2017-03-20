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
 *
 * 7. Most of the Boilerplate code will be implemented by Spring for us. In this case we would have the Service calling
 * the *Repository Classes to give us our required information back.
 *
 * 8. To make Spring aware that this Class is a Service, we mark it so using the @{@link Service} Annotation which
 * registers this Class in the Spring Container. And Spring will handle this Class with the benefits that Services get
 * from Spring. (e.g. AOP, if you want to intercept Services only in your application. Using the @Service Annotation can
 * be handy)
 */
@Service
public class CourseService {

    /**
     * 9. We need to access the Repository instance, so we get Spring to Inject the instance for us when we need it.
     */
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
