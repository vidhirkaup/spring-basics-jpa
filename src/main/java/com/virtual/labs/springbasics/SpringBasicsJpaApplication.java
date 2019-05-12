package com.virtual.labs.springbasics;

import com.virtual.labs.springbasics.repository.CourseRepository;
import com.virtual.labs.springbasics.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicsJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.saveStudentWithPassport();

        courseRepository.addReviewsForCourse();
    }
}
