package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROOM", schema = "MIS320_SCHEMA")
public class Room {
    private long roomId;
    private String roomNumber;
    private long squareFeet;
    private long roomTypeId;
    private long locationId;
    private RoomType roomTypeByRoomTypeId;
    private Location locationByLocationId;
    private List<RoomAmenity> roomAmenitiesByRoomId;
    private List<RoomReservation> roomReservationsByRoomId;

    @Id
    @GeneratedValue
    @Column(name = "ROOM_ID")
    public long getRoomId() {
        return roomId;
    }

    public Room setRoomId(long roomId) {
        this.roomId = roomId;
        return this;
    }

    @Basic
    @Column(name = "ROOM_NUMBER")
    public String getRoomNumber() {
        return roomNumber;
    }

    public Room setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    @Basic
    @Column(name = "SQUARE_FEET")
    public long getSquareFeet() {
        return squareFeet;
    }

    public Room setSquareFeet(long squareFeet) {
        this.squareFeet = squareFeet;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_TYPE_ID", referencedColumnName = "ROOM_TYPE_ID", nullable = false)
    public RoomType getRoomTypeByRoomTypeId() {
        return roomTypeByRoomTypeId;
    }

    public Room setRoomTypeByRoomTypeId(RoomType roomTypeByRoomTypeId) {
        this.roomTypeByRoomTypeId = roomTypeByRoomTypeId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID", nullable = false)
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    public Room setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
        return this;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public List<RoomAmenity> getRoomAmenitiesByRoomId() {
        return roomAmenitiesByRoomId;
    }

    public Room setRoomAmenitiesByRoomId(List<RoomAmenity> roomAmenitiesByRoomId) {
        this.roomAmenitiesByRoomId = roomAmenitiesByRoomId;
        return this;
    }

    @OneToMany(mappedBy = "room")
    public List<RoomReservation> getRoomReservationsByRoomId() {
        return roomReservationsByRoomId;
    }

    public Room setRoomReservationsByRoomId(List<RoomReservation> roomReservationsByRoomId) {
        this.roomReservationsByRoomId = roomReservationsByRoomId;
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

        Room room = (Room) o;

        if (roomId != room.roomId) {
            return false;
        }
        if (squareFeet != room.squareFeet) {
            return false;
        }
        if (roomTypeId != room.roomTypeId) {
            return false;
        }
        if (locationId != room.locationId) {
            return false;
        }
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        int result = (int) (roomId ^ (roomId >>> 32));
        result = 31 * result + (roomNumber != null ? roomNumber.hashCode() : 0);
        result = 31 * result + (int) (squareFeet ^ (squareFeet >>> 32));
        result = 31 * result + (int) (roomTypeId ^ (roomTypeId >>> 32));
        result = 31 * result + (int) (locationId ^ (locationId >>> 32));
        return result;
    }
}
