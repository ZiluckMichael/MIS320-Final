package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "RESERVATION", schema = "MIS320_SCHEMA")
public class Reservation {
    private long reservationId;
    private Time startDate;
    private Time endDate;
    private long guestId;
    private List<Invoice> invoicesByReservationId;
    private Guest guestByGuestId;
    private List<ReservationService> reservationServicesByReservationId;
    private List<RoomReservation> roomReservationsByReservationId;

    @Id
    @Column(name = "RESERVATION_ID")
    public long getReservationId() {
        return reservationId;
    }

    public Reservation setReservationId(long reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Basic
    @Column(name = "START_DATE")
    public Time getStartDate() {
        return startDate;
    }

    public Reservation setStartDate(Time startDate) {
        this.startDate = startDate;
        return this;
    }

    @Basic
    @Column(name = "END_DATE")
    public Time getEndDate() {
        return endDate;
    }

    public Reservation setEndDate(Time endDate) {
        this.endDate = endDate;
        return this;
    }

    @OneToMany(mappedBy = "reservationByReservationId")
    public List<Invoice> getInvoicesByReservationId() {
        return invoicesByReservationId;
    }

    public Reservation setInvoicesByReservationId(List<Invoice> invoicesByReservationId) {
        this.invoicesByReservationId = invoicesByReservationId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Guest getGuestByGuestId() {
        return guestByGuestId;
    }

    public Reservation setGuestByGuestId(Guest guestByGuestId) {
        this.guestByGuestId = guestByGuestId;
        return this;
    }

    @OneToMany(mappedBy = "reservation")
    public List<ReservationService> getReservationServicesByReservationId() {
        return reservationServicesByReservationId;
    }

    public Reservation setReservationServicesByReservationId(List<ReservationService> reservationServicesByReservationId) {
        this.reservationServicesByReservationId = reservationServicesByReservationId;
        return this;
    }

    @OneToMany(mappedBy = "reservation")
    public List<RoomReservation> getRoomReservationsByReservationId() {
        return roomReservationsByReservationId;
    }

    public Reservation setRoomReservationsByReservationId(List<RoomReservation> roomReservationsByReservationId) {
        this.roomReservationsByReservationId = roomReservationsByReservationId;
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

        Reservation that = (Reservation) o;

        if (reservationId != that.reservationId) {
            return false;
        }
        if (guestId != that.guestId) {
            return false;
        }
        if (!Objects.equals(startDate, that.startDate)) {
            return false;
        }
        if (!Objects.equals(endDate, that.endDate)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reservationId ^ (reservationId >>> 32));
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (int) (guestId ^ (guestId >>> 32));
        return result;
    }
}
