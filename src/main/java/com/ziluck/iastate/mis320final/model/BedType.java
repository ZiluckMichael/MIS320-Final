package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BED_TYPE", schema = "MIS320_SCHEMA")
public class BedType {
    private long bedTypeId;
    private String name;
    private List<RoomTypeBed> roomTypeBedsByBedTypeId;

    @Id
    @Column(name = "BED_TYPE_ID")
    public long getBedTypeId() {
        return bedTypeId;
    }

    public BedType setBedTypeId(long bedTypeId) {
        this.bedTypeId = bedTypeId;
        return this;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public BedType setName(String name) {
        this.name = name;
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

        BedType that = (BedType) o;

        if (bedTypeId != that.bedTypeId) {
            return false;
        }

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (bedTypeId ^ (bedTypeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bedTypeByBedTypeId")
    public List<RoomTypeBed> getRoomTypeBedsByBedTypeId() {
        return roomTypeBedsByBedTypeId;
    }

    public BedType setRoomTypeBedsByBedTypeId(List<RoomTypeBed> roomTypeBedsByBedTypeId) {
        this.roomTypeBedsByBedTypeId = roomTypeBedsByBedTypeId;
        return this;
    }
}
