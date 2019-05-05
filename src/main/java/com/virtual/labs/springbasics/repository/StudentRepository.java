package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.entity.Passport;
import com.virtual.labs.springbasics.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student save(Student student){
        if(student.getId() == null){
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("D44444");
        entityManager.persist(passport);

        Student student = new Student("David");
        student.setPassport(passport);
        entityManager.persist(student);
    }
}
