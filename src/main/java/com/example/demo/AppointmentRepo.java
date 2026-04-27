package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserId(Long userId);
}