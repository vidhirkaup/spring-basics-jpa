package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.SpringBasicsJpaApplication;
import com.virtual.labs.springbasics.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(10001L);
        assertEquals("Spring Boot JPA with Hibernate", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_new_course(){
        Course course = courseRepository.save(new Course("JUNIT - Test Insert of New Course"));
        assertEquals("JUNIT - Test Insert of New Course", courseRepository.findById(course.getId()).getName());
    }

    @Test
    @DirtiesContext
    public void save_existing_course(){
        Course newlyCreatedCourse = courseRepository.save(new Course("JUNIT - Test Update of existing Course"));
        Course updatedRecentlyCreatedCourse = courseRepository.save(new Course(newlyCreatedCourse.getId(), newlyCreatedCourse.getName().toUpperCase()));
        assertEquals("JUNIT - TEST UPDATE OF EXISTING COURSE", courseRepository.findById(updatedRecentlyCreatedCourse.getId()).getName());
    }

}