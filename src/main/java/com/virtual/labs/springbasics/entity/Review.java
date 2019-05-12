package com.virtual.labs.springbasics.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    @ManyToOne
    private Course course;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    public Review() {
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Review.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("rating='" + rating + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
