package com.example.demo;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserRepo userRepo;
    private final AppointmentRepo appointmentRepo;

    public MainController(UserRepo u, AppointmentRepo a) {
        this.userRepo = u;
        this.appointmentRepo = a;
    }

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepo.save(user);
        return "Registered Successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User req, HttpSession session) {
        Optional<User> user = userRepo.findByEmail(req.email);

        if (user.isPresent() && user.get().password.equals(req.password)) {
            session.setAttribute("userId", user.get().id);
            return "Login Success";
        }

        return "Invalid credentials";
    }

    // BOOK
    @PostMapping("/book")
    public String book(@RequestBody Appointment appt, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null)
            return "Login first";

        appt.userId = userId;
        appointmentRepo.save(appt);

        return "Appointment booked";
    }

    // VIEW
    @GetMapping("/appointments")
    public List<Appointment> getAppointments(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null)
            return new ArrayList<>();

        return appointmentRepo.findByUserId(userId);
    }
}