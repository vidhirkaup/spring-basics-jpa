package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.SpringBasicsJpaApplication;
import com.virtual.labs.springbasics.entity.Course;
import com.virtual.labs.springbasics.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

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
    public void save_new_course() {
        Course course = courseRepository.save(new Course("JUNIT - Test Insert of New Course"));
        assertEquals("JUNIT - Test Insert of New Course", courseRepository.findById(course.getId()).getName());
    }

    @Test
    @DirtiesContext
    public void save_existing_course() {
        Course newlyCreatedCourse = courseRepository.save(new Course("JUNIT - Test Update of existing Course"));
        Course updatedRecentlyCreatedCourse = courseRepository.save(new Course(newlyCreatedCourse.getId(), newlyCreatedCourse.getName().toUpperCase()));
        assertEquals("JUNIT - TEST UPDATE OF EXISTING COURSE", courseRepository.findById(updatedRecentlyCreatedCourse.getId()).getName());
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DirtiesContext
    public void save_null_course() {
        courseRepository.save(new Course(null));
    }

    @Test
    @Transactional
    public void retrieve_reviews_for_course() {
        Course course = courseRepository.findById(10003L);
        logger.info("Reviews -> {}", course.getReviews());
    }

    @Test
    public void retrieve_course_for_review() {
        Review review = entityManager.find(Review.class, 50004L);
        logger.info("Course for review -> {}", review.getCourse());
    }
}