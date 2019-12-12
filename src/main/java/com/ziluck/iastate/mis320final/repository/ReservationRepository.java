package com.ziluck.iastate.mis320final.repository;

import com.ziluck.iastate.mis320final.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT COALESCE(MAX(reservationId), 1) FROM Reservation")
    int getMaxId();
}
