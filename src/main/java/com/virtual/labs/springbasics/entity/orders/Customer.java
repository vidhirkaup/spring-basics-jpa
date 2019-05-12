package com.virtual.labs.springbasics.entity.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String apartment;

    private String street;

    private String city;

    private String zipCode;

    private String country;

    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
