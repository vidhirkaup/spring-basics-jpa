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
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBasicsJpaApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings({"JpaQlInspection", "JpaQueryApiInspection"})
    @Test
    public void jpql_query() {
        Query query = entityManager.createNamedQuery("query_get_all_courses");
        List courses = query.getResultList();
        logger.info("============= SELECT c FROM Course c =============");
        logger.info("{}", courses);
        logger.info("============= SELECT c FROM Course c =============");
    }

    @SuppressWarnings({"JpaQlInspection", "JpaQueryApiInspection"})
    @Test
    public void jpql_typed() {
        TypedQuery<Course> typedQuery = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> courses = typedQuery.getResultList();
        logger.info("============= SELECT c FROM Course c =============");
        logger.info("{}", courses);
        logger.info("============= SELECT c FROM Course c =============");
    }

    @SuppressWarnings({"JpaQlInspection", "JpaQueryApiInspection"})
    @Test
    public void jpql_where() {
        TypedQuery<Course> typedQuery = entityManager.createNamedQuery("query_get_specific_course", Course.class);
        List<Course> courses = typedQuery.getResultList();
        logger.info("============= SELECT c FROM Course c where name like '%In%' =============");
        logger.info("{}", courses);
        logger.info("============= SELECT c FROM Course c where name like '%In%' =============");
    }

}