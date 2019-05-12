package com.virtual.labs.springbasics;

import com.virtual.labs.springbasics.entity.Review;
import com.virtual.labs.springbasics.repository.CourseRepository;
import com.virtual.labs.springbasics.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBasicsJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;
    ;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicsJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.saveStudentWithPassport();

        Long courseId = 10003L;
        List<Review> reviews = Arrays.asList(
                new Review("4", "A 4-RATING"),
                new Review("5", "A 5-RATING"));
        courseRepository.addReviewsForCourse(courseId, reviews);

    }
}
