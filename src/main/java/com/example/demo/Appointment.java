package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "appoinment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Long userId;
    public String doctorName;
    public String date;
    public String time;
}