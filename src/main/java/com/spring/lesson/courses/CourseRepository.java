package com.spring.lesson.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by amuzanenhamo on 20/03/2017.
 *
 * Spring JPA provides the class for us so we won't need to
 * implement the typical CRUD methods as they are created
 * for us by Spring. With that we change our class to be an
 * interface.
 *
 * The goal of Spring Data repository abstraction is to
 * significantly reduce the amount of boilerplate code
 * required to implement data access layers for various
 * persistence stores.
 */
public interface CourseRepository extends CrudRepository<Course, String> {

    /**
     * We need to find courses by topic Id
     */
    //public List<Course> getCourseByTopicId(String topicId);
    public List<Course> findByTopicId(String topicId);

}
