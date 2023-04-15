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

    private Boolean representative;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_surname")
    private String clientSurname;

    @Column(name = "client_iin")
    private String clientIin;

    @Column(name = "issuing_department")
    private String issuingDepartment;

    @Column(name = "destination_address")
    private String destinationAddress;

    private Double price;

    @CreationTimestamp
    private Date createdAt;

    private Date deadline;

    private Boolean finished;

    private Boolean accepted;
}
