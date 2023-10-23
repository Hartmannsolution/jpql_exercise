package entity;

import javax.persistence.*;

@Entity
@Table(name="orderdetails")
@IdClass(OrderdetailsPK.class)
public class Orderdetail {
    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private Double priceEach;
    private Short orderLineNumber;
    private OrderEntity orderEntityByOrderNumber;
    private Product productByProductCode;

    public Orderdetail() {
    }

    @Id
    @Column(name = "orderNumber")
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @Column(name = "productCode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "quantityOrdered")
    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @Basic
    @Column(name = "priceEach")
    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    @Basic
    @Column(name = "orderLineNumber")
    public Short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdetail that = (Orderdetail) o;

        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (quantityOrdered != null ? !quantityOrdered.equals(that.quantityOrdered) : that.quantityOrdered != null)
            return false;
        if (priceEach != null ? !priceEach.equals(that.priceEach) : that.priceEach != null) return false;
        if (orderLineNumber != null ? !orderLineNumber.equals(that.orderLineNumber) : that.orderLineNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        result = 31 * result + (priceEach != null ? priceEach.hashCode() : 0);
        result = 31 * result + (orderLineNumber != null ? orderLineNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderNumber")
    public OrderEntity getOrdersByOrderNumber() {
        return orderEntityByOrderNumber;
    }

    public void setOrdersByOrderNumber(OrderEntity orderEntityByOrderNumber) {
        this.orderEntityByOrderNumber = orderEntityByOrderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "productCode")
    public Product getProductsByProductCode() {
        return productByProductCode;
    }

    public void setProductsByProductCode(Product productByProductCode) {
        this.productByProductCode = productByProductCode;
    }
}
