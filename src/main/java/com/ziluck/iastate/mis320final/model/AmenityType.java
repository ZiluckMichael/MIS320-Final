package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AMENITY_TYPE", schema = "MIS320_SCHEMA")
public class AmenityType {
    private long amenityTypeId;
    private String name;
    private String description;
    private long quantity;
    private List<RoomAmenity> roomAmenitiesByAmenityTypeId;

    @Id
    @GeneratedValue
    @Column(name = "AMENITY_TYPE_ID")
    public long getAmenityTypeId() {
        return amenityTypeId;
    }

    public AmenityType setAmenityTypeId(long amenityTypeId) {
        this.amenityTypeId = amenityTypeId;
        return this;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public AmenityType setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public AmenityType setDescription(String description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "QUANTITY")
    public long getQuantity() {
        return quantity;
    }

    public AmenityType setQuantity(long quantity) {
        this.quantity = quantity;
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

        AmenityType that = (AmenityType) o;

        if (amenityTypeId != that.amenityTypeId) {
            return false;
        }
        if (quantity != that.quantity) {
            return false;
        }
        if (!Objects.equals(name, that.name)) {
            return false;
        }
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (amenityTypeId ^ (amenityTypeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (quantity ^ (quantity >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "amenityTypeByAmenityTypeId")
    public List<RoomAmenity> getRoomAmenitiesByAmenityTypeId() {
        return roomAmenitiesByAmenityTypeId;
    }

    public AmenityType setRoomAmenitiesByAmenityTypeId(List<RoomAmenity> roomAmenitiesByAmenityTypeId) {
        this.roomAmenitiesByAmenityTypeId = roomAmenitiesByAmenityTypeId;
        return this;
    }
}
