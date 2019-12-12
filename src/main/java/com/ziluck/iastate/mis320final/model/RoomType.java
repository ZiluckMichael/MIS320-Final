package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROOM_TYPE", schema = "MIS320_SCHEMA")
public class RoomType {
    private long roomTypeId;
    private String name;
    private String description;
    private long defaultRate;
    private List<Room> roomsByRoomTypeId;
    private List<RoomTypeBed> roomTypeBedsByRoomTypeId;

    @Id
    @GeneratedValue
    @Column(name = "ROOM_TYPE_ID")
    public long getRoomTypeId() {
        return roomTypeId;
    }

    public RoomType setRoomTypeId(long roomTypeId) {
        this.roomTypeId = roomTypeId;
        return this;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public RoomType setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public RoomType setDescription(String description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "DEFAULT_RATE")
    public long getDefaultRate() {
        return defaultRate;
    }

    public RoomType setDefaultRate(long defaultRate) {
        this.defaultRate = defaultRate;
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

        RoomType that = (RoomType) o;

        if (roomTypeId != that.roomTypeId) {
            return false;
        }
        if (defaultRate != that.defaultRate) {
            return false;
        }
        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (roomTypeId ^ (roomTypeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (defaultRate ^ (defaultRate >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "roomTypeByRoomTypeId")
    public List<Room> getRoomsByRoomTypeId() {
        return roomsByRoomTypeId;
    }

    public RoomType setRoomsByRoomTypeId(List<Room> roomsByRoomTypeId) {
        this.roomsByRoomTypeId = roomsByRoomTypeId;
        return this;
    }

    @OneToMany(mappedBy = "roomTypeByRoomTypeId")
    public List<RoomTypeBed> getRoomTypeBedsByRoomTypeId() {
        return roomTypeBedsByRoomTypeId;
    }

    public RoomType setRoomTypeBedsByRoomTypeId(List<RoomTypeBed> roomTypeBedsByRoomTypeId) {
        this.roomTypeBedsByRoomTypeId = roomTypeBedsByRoomTypeId;
        return this;
    }
}
