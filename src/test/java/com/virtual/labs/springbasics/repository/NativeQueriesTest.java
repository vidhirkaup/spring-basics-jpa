package com.virtual.labs.springbasics.repository;

import com.virtual.labs.springbasics.SpringBasicsJpaApplication;
import com.virtual.labs.springbasics.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void native_query_basic() {
        Query query = entityManager.createNativeQuery("SELECT * FROM Course", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("============= SELECT * FROM Course =============");
        logger.info("{}", courses);
        logger.info("============= SELECT * FROM Course =============");
    }

    @Test
    public void native_query_with_parameter() {
        Query query = entityManager.createNativeQuery("SELECT * FROM Course where id = ?", Course.class);
        query.setParameter(1, 10004L);
        List<Course> courses = query.getResultList();
        logger.info("============= SELECT * FROM Course  where id = ? =============");
        logger.info("{}", courses);
        logger.info("============= SELECT * FROM Course  where id = ? =============");
    }

    @SuppressWarnings("JpaQueryApiInspection")
    @Test
    public void native_query_with_named_parameter() {
        Query query = entityManager.createNativeQuery("SELECT * FROM Course where id = :id", Course.class);
        query.setParameter("id", 10005L);
        List<Course> courses = query.getResultList();
        logger.info("============= SELECT * FROM Course  where id = :id =============");
        logger.info("{}", courses);
        logger.info("============= SELECT * FROM Course  where id = :id =============");
    }

    @Test
    @Transactional
    public void native_query_to_update() {
        Query query = entityManager.createNativeQuery("UPDATE Course SET last_updated_date = SYSDATE()", Course.class);
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("============= UPDATE Course SET last_updated_date = SYSDATE() =============");
        logger.info("{}", numberOfRowsUpdated);
        logger.info("============= UPDATE Course SET last_updated_date = SYSDATE() =============");
    }


}