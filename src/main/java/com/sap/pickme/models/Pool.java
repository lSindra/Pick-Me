package com.sap.pickme.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POOL")
public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private int id;

    @DateTimeFormat
    @Column(name = "DATE")
    private Date date;

}
