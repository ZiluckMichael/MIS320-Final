package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_RESERVATION", schema = "MIS320_SCHEMA")
public class RoomReservation {
    private long roomReservationId;
    private long roomId;
    private long reservationId;
    private Room roomByRoomId;
    private Reservation reservationByReservationId;

    @Id
    @Column(name = "ROOM_RESERVATION_ID")
    public long getRoomReservationId() {
        return roomReservationId;
    }

    public void setRoomReservationId(long roomReservationId) {
        this.roomReservationId = roomReservationId;
    }

    @Basic
    @Column(name = "ROOM_ID")
    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "RESERVATION_ID")
    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoomReservation that = (RoomReservation) o;

        if (roomReservationId != that.roomReservationId) {
            return false;
        }
        if (roomId != that.roomId) {
            return false;
        }
        return reservationId == that.reservationId;
    }

    @Override
    public int hashCode() {
        int result = (int) (roomReservationId ^ (roomReservationId >>> 32));
        result = 31 * result + (int) (roomId ^ (roomId >>> 32));
        result = 31 * result + (int) (reservationId ^ (reservationId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", nullable = false)
    public Room getRoom() {
        return roomByRoomId;
    }

    public void setRoom(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "RESERVATION_ID", nullable = false)
    public Reservation getReservation() {
        return reservationByReservationId;
    }

    public void setReservation(Reservation reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
    }
}
