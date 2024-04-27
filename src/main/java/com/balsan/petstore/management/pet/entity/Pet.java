package com.balsan.petstore.management.pet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pet", schema = "pets")
public class Pet {

    @Id
    @SequenceGenerator(name = "pets_seq", sequenceName = "pets_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pets_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "dob")
    private java.sql.Date dob;

    @Column(name = "approximate_age")
    private Integer approximateAge;
}