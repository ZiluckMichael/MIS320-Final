package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "INVOICE_PAYMENT", schema = "MIS320_SCHEMA")
public class InvoicePayment {
    private long invoicePaymentId;
    private Time paymentDate;
    private long paymentAmount;
    private long invoiceId;
    private long paymentCardId;
    private Invoice invoiceByInvoiceId;
    private PaymentCard paymentCardByPaymentCardId;

    @Id
    @Column(name = "INVOICE_PAYMENT_ID")
    public long getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public InvoicePayment setInvoicePaymentId(long invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
        return this;
    }

    @Basic
    @Column(name = "PAYMENT_DATE")
    public Time getPaymentDate() {
        return paymentDate;
    }

    public InvoicePayment setPaymentDate(Time paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    @Basic
    @Column(name = "PAYMENT_AMOUNT")
    public long getPaymentAmount() {
        return paymentAmount;
    }

    public InvoicePayment setPaymentAmount(long paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID", nullable = false)
    public Invoice getInvoiceByInvoiceId() {
        return invoiceByInvoiceId;
    }

    public InvoicePayment setInvoiceByInvoiceId(Invoice invoiceByInvoiceId) {
        this.invoiceByInvoiceId = invoiceByInvoiceId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "PAYMENT_CARD_ID", referencedColumnName = "PAYMENT_CARD_ID", nullable = false)
    public PaymentCard getPaymentCardByPaymentCardId() {
        return paymentCardByPaymentCardId;
    }

    public InvoicePayment setPaymentCardByPaymentCardId(PaymentCard paymentCardByPaymentCardId) {
        this.paymentCardByPaymentCardId = paymentCardByPaymentCardId;
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

        InvoicePayment that = (InvoicePayment) o;

        if (invoicePaymentId != that.invoicePaymentId) {
            return false;
        }
        if (paymentAmount != that.paymentAmount) {
            return false;
        }
        if (invoiceId != that.invoiceId) {
            return false;
        }
        if (paymentCardId != that.paymentCardId) {
            return false;
        }
        return Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (invoicePaymentId ^ (invoicePaymentId >>> 32));
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (int) (paymentAmount ^ (paymentAmount >>> 32));
        result = 31 * result + (int) (invoiceId ^ (invoiceId >>> 32));
        result = 31 * result + (int) (paymentCardId ^ (paymentCardId >>> 32));
        return result;
    }
}
