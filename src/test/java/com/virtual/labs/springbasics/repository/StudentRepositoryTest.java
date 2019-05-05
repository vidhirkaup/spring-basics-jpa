package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.SpringBasicsJpaApplication;
import com.virtual.labs.springbasics.entity.Passport;
import com.virtual.labs.springbasics.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void find_student_and_passport() {
        Student student = entityManager.find(Student.class, 20002L);
        logger.info("================= Student {}", student);
        logger.info("================= Passport {}", student.getPassport());
    }

    @Test
    @Transactional
    public void find_passport_and_student() {
        Passport passport = entityManager.find(Passport.class, 40003L);
        logger.info("============= Passport {}", passport);
        logger.info("============= Student {}", passport.getStudent());
    }
}
