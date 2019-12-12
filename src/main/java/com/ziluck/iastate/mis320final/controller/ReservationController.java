package com.ziluck.iastate.mis320final.controller;

import com.ziluck.iastate.mis320final.model.Reservation;
import com.ziluck.iastate.mis320final.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    @ResponseBody
    public Reservation getReservationById(@RequestParam long reservationId) {
        return reservationRepository.getByReservationId(reservationId);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
