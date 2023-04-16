package com.jilnash.hacknu23.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "orderr")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "issuing_department")
    private String issuingDepartment;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_surname")
    private String clientSurname;

    @Column(name = "client_iin")
    private String clientIin;

    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "destination_street")
    private String destinationStreet;

    @Column(name = "destination_home")
    private String destinationHome;

    @Column(name = "destination_flat")
    private String destinationFlat;

    private Double price;

    @CreationTimestamp
    private Date createdAt;

    @Column(name = "finished_at")
    private Date finishedAt;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Courier courier;

    @ManyToOne
    private Service service;
}
