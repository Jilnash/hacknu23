package com.jilnash.hacknu23.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courier")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    private String password;

    @ManyToOne
    private Service service;
}
