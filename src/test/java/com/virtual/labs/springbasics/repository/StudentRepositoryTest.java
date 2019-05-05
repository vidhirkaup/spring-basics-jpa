package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.SpringBasicsJpaApplication;
import com.virtual.labs.springbasics.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById_student_and_passport() {
        Student student = entityManager.find(Student.class, 20002L);
        logger.info("================= Student {}", student);
    }
}
