package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

//    public Course save(Course course) {}

//    public void deleteById(Long id){}

}
