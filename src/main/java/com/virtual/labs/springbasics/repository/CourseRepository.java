package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.entity.Course;
import com.virtual.labs.springbasics.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEntityManager() {
        Course bootCourse = new Course("boot in 10 steps");
        entityManager.persist(bootCourse);
        logger.info("----- {}", bootCourse);

        bootCourse.setName("BOOT IN 10 STEPS - updated");
        logger.info("----- {}", bootCourse);
        entityManager.flush();

        // Trying flush() and detach()
        Course angularCourse = new Course("angular course");
        entityManager.persist(angularCourse);
        logger.info("----- {}", angularCourse);
        entityManager.flush();

        entityManager.detach(angularCourse);
        angularCourse.setName("ANGULAR COURSE - updated");
        logger.info("----- {}", angularCourse);


        // Trying refresh
        Course reactCourse = new Course("reactJS course");
        entityManager.persist(reactCourse);
        logger.info("----- {}", reactCourse);

        Course dojoCourse = new Course("dojo course");
        entityManager.persist(dojoCourse);
        logger.info("----- {}", dojoCourse);

        entityManager.flush();

        reactCourse.setName("reactJS course - updated");
        dojoCourse.setName("dojo course - updated");

        entityManager.refresh(reactCourse);
        logger.info("##### {}", reactCourse);
        logger.info("##### {}", dojoCourse);

        entityManager.flush();

    }

    public void addReviewsForCourse() {

        Course course = findById(10003L);

        Review review1 = new Review("4", "a 4-rating");
        Review review2 = new Review("5", "a 5-rating");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }
}
