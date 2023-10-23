package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payments")
@IdClass(PaymentsPK.class)
public class Payment {
    private Integer customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private Double amount;
    private Customer customer;

    public Payment() {
    }

    @Id
    @Column(name = "customerNumber")
    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @Column(name = "checkNumber")
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Basic
    @Column(name = "paymentDate")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (customerNumber != null ? !customerNumber.equals(payment.customerNumber) : payment.customerNumber != null)
            return false;
        if (checkNumber != null ? !checkNumber.equals(payment.checkNumber) : payment.checkNumber != null)
            return false;
        if (paymentDate != null ? !paymentDate.equals(payment.paymentDate) : payment.paymentDate != null)
            return false;
        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerNumber != null ? customerNumber.hashCode() : 0;
        result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerNumber")
    public Customer getCustomersByCustomerNumber() {
        return customer;
    }

    public void setCustomersByCustomerNumber(Customer customer) {
        this.customer = customer;
    }
}
