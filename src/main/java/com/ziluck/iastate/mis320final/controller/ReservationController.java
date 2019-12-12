package com.ziluck.iastate.mis320final.controller;

import com.ziluck.iastate.mis320final.model.Reservation;
import com.ziluck.iastate.mis320final.model.Room;
import com.ziluck.iastate.mis320final.repository.ReservationRepository;
import com.ziluck.iastate.mis320final.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;

    public ReservationController(ReservationRepository reservationRepository,
                                 RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    @ResponseBody
    public Reservation getReservationById(@RequestParam long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @PostMapping
    @ResponseBody
    public Reservation save(@RequestBody Reservation reservation) {
        if (reservation.getReservationId() == 0) {
            reservation.setReservationId(reservationRepository.getMaxId() + 1);
        }
        return reservationRepository.save(reservation);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> getFreeRooms() {
        return roomRepository.findAll();
    }
}
