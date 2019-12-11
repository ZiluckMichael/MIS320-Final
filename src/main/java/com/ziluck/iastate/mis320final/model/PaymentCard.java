package com.ziluck.iastate.mis320final.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT_CARD", schema = "MIS320_SCHEMA")
public class PaymentCard {
    private long paymentCardId;
    private String cardNumber;
    private long expirationMonth;
    private long expirationYear;
    private Long securityValue;
    private long guestId;
    private List<InvoicePayment> invoicePaymentsByPaymentCardId;
    private Guest guestByGuestId;

    @Id
    @Column(name = "PAYMENT_CARD_ID")
    public long getPaymentCardId() {
        return paymentCardId;
    }

    public PaymentCard setPaymentCardId(long paymentCardId) {
        this.paymentCardId = paymentCardId;
        return this;
    }

    @Basic
    @Column(name = "CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }

    public PaymentCard setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    @Basic
    @Column(name = "EXPIRATION_MONTH")
    public long getExpirationMonth() {
        return expirationMonth;
    }

    public PaymentCard setExpirationMonth(long expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    @Basic
    @Column(name = "EXPIRATION_YEAR")
    public long getExpirationYear() {
        return expirationYear;
    }

    public PaymentCard setExpirationYear(long expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }

    @Basic
    @Column(name = "SECURITY_VALUE")
    public Long getSecurityValue() {
        return securityValue;
    }

    public PaymentCard setSecurityValue(Long securityValue) {
        this.securityValue = securityValue;
        return this;
    }

    @OneToMany(mappedBy = "paymentCardByPaymentCardId")
    public List<InvoicePayment> getInvoicePaymentsByPaymentCardId() {
        return invoicePaymentsByPaymentCardId;
    }

    public PaymentCard setInvoicePaymentsByPaymentCardId(List<InvoicePayment> invoicePaymentsByPaymentCardId) {
        this.invoicePaymentsByPaymentCardId = invoicePaymentsByPaymentCardId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Guest getGuestByGuestId() {
        return guestByGuestId;
    }

    public PaymentCard setGuestByGuestId(Guest guestByGuestId) {
        this.guestByGuestId = guestByGuestId;
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

        PaymentCard that = (PaymentCard) o;

        if (paymentCardId != that.paymentCardId) {
            return false;
        }
        if (expirationMonth != that.expirationMonth) {
            return false;
        }
        if (expirationYear != that.expirationYear) {
            return false;
        }
        if (guestId != that.guestId) {
            return false;
        }
        if (!Objects.equals(cardNumber, that.cardNumber)) {
            return false;
        }

        return Objects.equals(securityValue, that.securityValue);
    }

    @Override
    public int hashCode() {
        int result = (int) (paymentCardId ^ (paymentCardId >>> 32));
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (int) (expirationMonth ^ (expirationMonth >>> 32));
        result = 31 * result + (int) (expirationYear ^ (expirationYear >>> 32));
        result = 31 * result + (securityValue != null ? securityValue.hashCode() : 0);
        result = 31 * result + (int) (guestId ^ (guestId >>> 32));
        return result;
    }
}
