package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_AMENITY", schema = "MIS320_SCHEMA")
public class RoomAmenity {
    private long roomAmenityId;
    private long roomId;
    private long amenityTypeId;
    private Room roomByRoomId;
    private AmenityType amenityTypeByAmenityTypeId;

    @Id
    @Column(name = "ROOM_AMENITY_ID")
    public long getRoomAmenityId() {
        return roomAmenityId;
    }

    public void setRoomAmenityId(long roomAmenityId) {
        this.roomAmenityId = roomAmenityId;
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
    @Column(name = "AMENITY_TYPE_ID")
    public long getAmenityTypeId() {
        return amenityTypeId;
    }

    public void setAmenityTypeId(long amenityTypeId) {
        this.amenityTypeId = amenityTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoomAmenity that = (RoomAmenity) o;

        if (roomAmenityId != that.roomAmenityId) {
            return false;
        }
        if (roomId != that.roomId) {
            return false;
        }

        return amenityTypeId == that.amenityTypeId;
    }

    @Override
    public int hashCode() {
        int result = (int) (roomAmenityId ^ (roomAmenityId >>> 32));
        result = 31 * result + (int) (roomId ^ (roomId >>> 32));
        result = 31 * result + (int) (amenityTypeId ^ (amenityTypeId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", nullable = false)
    public Room getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "AMENITY_TYPE_ID", referencedColumnName = "AMENITY_TYPE_ID", nullable = false)
    public AmenityType getAmenityTypeByAmenityTypeId() {
        return amenityTypeByAmenityTypeId;
    }

    public void setAmenityTypeByAmenityTypeId(AmenityType amenityTypeByAmenityTypeId) {
        this.amenityTypeByAmenityTypeId = amenityTypeByAmenityTypeId;
    }
}
