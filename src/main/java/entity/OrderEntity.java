package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class OrderEntity {
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private List<Orderdetail> orderdetailByOrderNumber;
    private Customer customerByCustomerNumber;

    @Id
    @Column(name = "orderNumber")
    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "orderDate")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "requiredDate")
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Basic
    @Column(name = "shippedDate")
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity orderEntity = (OrderEntity) o;

        if (orderNumber != null ? !orderNumber.equals(orderEntity.orderNumber) : orderEntity.orderNumber != null) return false;
        if (orderDate != null ? !orderDate.equals(orderEntity.orderDate) : orderEntity.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(orderEntity.requiredDate) : orderEntity.requiredDate != null)
            return false;
        if (shippedDate != null ? !shippedDate.equals(orderEntity.shippedDate) : orderEntity.shippedDate != null) return false;
        if (status != null ? !status.equals(orderEntity.status) : orderEntity.status != null) return false;
        if (comments != null ? !comments.equals(orderEntity.comments) : orderEntity.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderNumber")
    public List<Orderdetail> getOrderdetailsByOrderNumber() {
        return orderdetailByOrderNumber;
    }

    public void setOrderdetailsByOrderNumber(List<Orderdetail> orderdetailByOrderNumber) {
        this.orderdetailByOrderNumber = orderdetailByOrderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    public Customer getCustomersByCustomerNumber() {
        return customerByCustomerNumber;
    }

    public void setCustomersByCustomerNumber(Customer customerByCustomerNumber) {
        this.customerByCustomerNumber = customerByCustomerNumber;
    }
}
