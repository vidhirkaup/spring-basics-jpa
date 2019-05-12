package com.virtual.labs.springbasics.entity.orders;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private LocalDateTime date;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY, optional = false)
    private Invoice invoice;
}
