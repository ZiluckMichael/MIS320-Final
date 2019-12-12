package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation getByReservationId(long reservationId);
}
