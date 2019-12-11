package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "GUEST", schema = "MIS320_SCHEMA")
public class Guest extends Person {
    private String rewardsNumber;
    private long rewardsPoints;
    private List<PaymentCard> paymentCardsByPersonId;
    private List<Reservation> reservationsByPersonId;

    @Basic
    @Column(name = "REWARDS_NUMBER")
    public String getRewardsNumber() {
        return rewardsNumber;
    }

    public void setRewardsNumber(String rewardsNumber) {
        this.rewardsNumber = rewardsNumber;
    }

    @Basic
    @Column(name = "REWARDS_POINTS")
    public long getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(long rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    @OneToMany(mappedBy = "guestByGuestId")
    public List<PaymentCard> getPaymentCardsByPersonId() {
        return paymentCardsByPersonId;
    }

    public Guest setPaymentCardsByPersonId(List<PaymentCard> paymentCardsByPersonId) {
        this.paymentCardsByPersonId = paymentCardsByPersonId;
        return this;
    }

    @OneToMany(mappedBy = "guestByGuestId")
    public List<Reservation> getReservationsByPersonId() {
        return reservationsByPersonId;
    }

    public Guest setReservationsByPersonId(List<Reservation> reservationsByPersonId) {
        this.reservationsByPersonId = reservationsByPersonId;
        return this;
    }
}
