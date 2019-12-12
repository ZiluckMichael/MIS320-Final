package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "RESERVATION", schema = "MIS320_SCHEMA")
public class Reservation {
    private long reservationId;
    private Date startDate;
    private Date endDate;
    private long guestId;

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
    public Date getStartDate() {
        return startDate;
    }

    public Reservation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Basic
    @Column(name = "END_DATE")
    public Date getEndDate() {
        return endDate;
    }

    public Reservation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Basic
    @Column(name = "GUEST_ID")
    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
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
        return Objects.equals(endDate, that.endDate);
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
