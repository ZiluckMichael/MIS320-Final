package com.ziluck.iastate.mis320final.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "INVOICE", schema = "MIS320_SCHEMA")
public class Invoice {
    private long invoiceId;
    private Time createdOn;
    private Time dueOn;
    private Time fullyPaidOn;
    private long reservationId;
    private long invoiceStatusId;
    private String notes;
    private Reservation reservationByReservationId;
    private InvoiceStatus invoiceStatusByInvoiceStatusId;
    private List<InvoicePayment> invoicePaymentsByInvoiceId;

    @Id
    @Column(name = "INVOICE_ID")
    public long getInvoiceId() {
        return invoiceId;
    }

    public Invoice setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public Time getCreatedOn() {
        return createdOn;
    }

    public Invoice setCreatedOn(Time createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Basic
    @Column(name = "DUE_ON")
    public Time getDueOn() {
        return dueOn;
    }

    public Invoice setDueOn(Time dueOn) {
        this.dueOn = dueOn;
        return this;
    }

    @Basic
    @Column(name = "FULLY_PAID_ON")
    public Time getFullyPaidOn() {
        return fullyPaidOn;
    }

    public Invoice setFullyPaidOn(Time fullyPaidOn) {
        this.fullyPaidOn = fullyPaidOn;
        return this;
    }

    @Basic
    @Column(name = "NOTES")
    public String getNotes() {
        return notes;
    }

    public Invoice setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID", referencedColumnName = "RESERVATION_ID", nullable = false)
    public Reservation getReservationByReservationId() {
        return reservationByReservationId;
    }

    public Invoice setReservationByReservationId(Reservation reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "INVOICE_STATUS_ID", referencedColumnName = "INVOICE_STATUS_ID", nullable = false)
    public InvoiceStatus getInvoiceStatusByInvoiceStatusId() {
        return invoiceStatusByInvoiceStatusId;
    }

    public Invoice setInvoiceStatusByInvoiceStatusId(InvoiceStatus invoiceStatusByInvoiceStatusId) {
        this.invoiceStatusByInvoiceStatusId = invoiceStatusByInvoiceStatusId;
        return this;
    }

    @OneToMany(mappedBy = "invoiceByInvoiceId")
    public List<InvoicePayment> getInvoicePaymentsByInvoiceId() {
        return invoicePaymentsByInvoiceId;
    }

    public Invoice setInvoicePaymentsByInvoiceId(List<InvoicePayment> invoicePaymentsByInvoiceId) {
        this.invoicePaymentsByInvoiceId = invoicePaymentsByInvoiceId;
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

        Invoice that = (Invoice) o;

        if (invoiceId != that.invoiceId) {
            return false;
        }
        if (reservationId != that.reservationId) {
            return false;
        }
        if (invoiceStatusId != that.invoiceStatusId) {
            return false;
        }
        if (!Objects.equals(createdOn, that.createdOn)) {
            return false;
        }
        if (!Objects.equals(dueOn, that.dueOn)) {
            return false;
        }
        if (!Objects.equals(fullyPaidOn, that.fullyPaidOn)) {
            return false;
        }
        return Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        int result = (int) (invoiceId ^ (invoiceId >>> 32));
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (dueOn != null ? dueOn.hashCode() : 0);
        result = 31 * result + (fullyPaidOn != null ? fullyPaidOn.hashCode() : 0);
        result = 31 * result + (int) (reservationId ^ (reservationId >>> 32));
        result = 31 * result + (int) (invoiceStatusId ^ (invoiceStatusId >>> 32));
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
