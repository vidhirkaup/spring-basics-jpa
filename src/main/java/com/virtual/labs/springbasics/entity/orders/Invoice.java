package com.virtual.labs.springbasics.entity.orders;

import javax.persistence.*;

@Entity
@Table(name = "Invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

}
