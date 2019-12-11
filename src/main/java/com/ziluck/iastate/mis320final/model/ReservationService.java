package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION_SERVICE", schema = "MIS320_SCHEMA")
public class ReservationService {
    private long reservationServiceId;
    private long reservationId;
    private long serviceId;
    private Reservation reservationByReservationId;
    private Service serviceByServiceId;

    @Id
    @Column(name = "RESERVATION_SERVICE_ID")
    public long getReservationServiceId() {
        return reservationServiceId;
    }

    public ReservationService setReservationServiceId(long reservationServiceId) {
        this.reservationServiceId = reservationServiceId;
        return this;
    }

    @Basic
    @Column(name = "RESERVATION_ID")
    public long getReservationId() {
        return reservationId;
    }

    public ReservationService setReservationId(long reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Basic
    @Column(name = "SERVICE_ID")
    public long getServiceId() {
        return serviceId;
    }

    public ReservationService setServiceId(long serviceId) {
        this.serviceId = serviceId;
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

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "RESERVATION_ID", nullable = false)
    public Reservation getReservationByReservationId() {
        return reservationByReservationId;
    }

    public ReservationService setReservationByReservationId(Reservation reservationByReservationId) {
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
}
