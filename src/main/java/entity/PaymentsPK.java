package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PaymentsPK implements Serializable {
    private Integer customerNumber;
    private String checkNumber;

    @Column(name = "customerNumber")
    @Id
    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Column(name = "checkNumber")
    @Id
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentsPK pk = (PaymentsPK) o;

        if (customerNumber != null ? !customerNumber.equals(pk.customerNumber) : pk.customerNumber != null)
            return false;
        if (checkNumber != null ? !checkNumber.equals(pk.checkNumber) : pk.checkNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerNumber != null ? customerNumber.hashCode() : 0;
        result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
        return result;
    }
}
