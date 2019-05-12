package com.virtual.labs.springbasics.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "Passport")
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Passport.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("number='" + number + "'")
                .toString();
    }
}
