package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderdetailsPK implements Serializable {
    private Integer orderNumber;
    private String productCode;

    @Column(name = "orderNumber")
    @Id
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "productCode")
    @Id
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailsPK pk = (OrderdetailsPK) o;

        if (orderNumber != null ? !orderNumber.equals(pk.orderNumber) : pk.orderNumber != null) return false;
        if (productCode != null ? !productCode.equals(pk.productCode) : pk.productCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        return result;
    }
}
