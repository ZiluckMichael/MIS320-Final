package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;

@Entity
@Table(name = "ROOM_TYPE_BED", schema = "MIS320_SCHEMA")
public class RoomTypeBed {
    private long roomBedId;
    private long roomTypeId;
    private long bedTypeId;
    private RoomType roomTypeByRoomTypeId;
    private BedType bedTypeByBedTypeId;

    @Id
    @GeneratedValue
    @Column(name = "ROOM_BED_ID")
    public long getRoomBedId() {
        return roomBedId;
    }

    public RoomTypeBed setRoomBedId(long roomBedId) {
        this.roomBedId = roomBedId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_TYPE_ID", referencedColumnName = "ROOM_TYPE_ID", nullable = false)
    public RoomType getRoomTypeByRoomTypeId() {
        return roomTypeByRoomTypeId;
    }

    public RoomTypeBed setRoomTypeByRoomTypeId(RoomType roomTypeByRoomTypeId) {
        this.roomTypeByRoomTypeId = roomTypeByRoomTypeId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "BED_TYPE_ID", referencedColumnName = "BED_TYPE_ID", nullable = false)
    public BedType getBedTypeByBedTypeId() {
        return bedTypeByBedTypeId;
    }

    public RoomTypeBed setBedTypeByBedTypeId(BedType bedTypeByBedTypeId) {
        this.bedTypeByBedTypeId = bedTypeByBedTypeId;
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

        RoomTypeBed that = (RoomTypeBed) o;

        if (roomBedId != that.roomBedId) {
            return false;
        }
        if (roomTypeId != that.roomTypeId) {
            return false;
        }
        return bedTypeId == that.bedTypeId;
    }

    @Override
    public int hashCode() {
        int result = (int) (roomBedId ^ (roomBedId >>> 32));
        result = 31 * result + (int) (roomTypeId ^ (roomTypeId >>> 32));
        result = 31 * result + (int) (bedTypeId ^ (bedTypeId >>> 32));
        return result;
    }
}
