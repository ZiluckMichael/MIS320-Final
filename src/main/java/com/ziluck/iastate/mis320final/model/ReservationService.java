package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_SERVICE", schema = "MIS320_SCHEMA")
public class ReservationService {
    private long reservationServiceId;
    private long reservationId;
    private long serviceId;
    private Reservation reservationByReservationId;
    private Service serviceByServiceId;

    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_SERVICE_ID")
    public long getReservationServiceId() {
        return reservationServiceId;
    }

    public ReservationService setReservationServiceId(long reservationServiceId) {
        this.reservationServiceId = reservationServiceId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "RESERVATION_ID", nullable = false)
    public Reservation getReservation() {
        return reservationByReservationId;
    }

    public ReservationService setReservation(Reservation reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID", nullable = false)
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public ReservationService setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReservationService that = (ReservationService) o;

        if (reservationServiceId != that.reservationServiceId) {
            return false;
        }
        if (reservationId != that.reservationId) {
            return false;
        }

        return serviceId == that.serviceId;
    }

    @Override
    public int hashCode() {
        int result = (int) (reservationServiceId ^ (reservationServiceId >>> 32));
        result = 31 * result + (int) (reservationId ^ (reservationId >>> 32));
        result = 31 * result + (int) (serviceId ^ (serviceId >>> 32));
        return result;
    }
}
