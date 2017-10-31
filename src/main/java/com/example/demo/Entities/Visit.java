package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "visiters")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "description")
    public String description;
}
