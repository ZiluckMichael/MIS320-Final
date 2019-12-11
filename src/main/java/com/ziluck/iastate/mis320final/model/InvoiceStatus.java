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
@Table(name = "INVOICE_STATUS", schema = "MIS320_SCHEMA")
public class InvoiceStatus {
    private long invoiceStatusId;
    private String name;
    private List<Invoice> invoicesByInvoiceStatusId;

    @Id
    @Column(name = "INVOICE_STATUS_ID")
    public long getInvoiceStatusId() {
        return invoiceStatusId;
    }

    public InvoiceStatus setInvoiceStatusId(long invoiceStatusId) {
        this.invoiceStatusId = invoiceStatusId;
        return this;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public InvoiceStatus setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "invoiceStatusByInvoiceStatusId")
    public List<Invoice> getInvoicesByInvoiceStatusId() {
        return invoicesByInvoiceStatusId;
    }

    public InvoiceStatus setInvoicesByInvoiceStatusId(List<Invoice> invoicesByInvoiceStatusId) {
        this.invoicesByInvoiceStatusId = invoicesByInvoiceStatusId;
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

        InvoiceStatus that = (InvoiceStatus) o;

        if (invoiceStatusId != that.invoiceStatusId) {
            return false;
        }
        if (!Objects.equals(name, that.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (invoiceStatusId ^ (invoiceStatusId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
