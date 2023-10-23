package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    private String productCode;
    private String productName;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Short quantityInStock;
    private Double buyPrice;
    private Double msrp;
    private List<Orderdetail> orderdetailByProductCode;
    private Productline productlineByProductLine;

    @Id
    @Column(name = "productCode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productScale")
    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Basic
    @Column(name = "productVendor")
    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Basic
    @Column(name = "productDescription")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "quantityInStock")
    public Short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Basic
    @Column(name = "buyPrice")
    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Basic
    @Column(name = "MSRP")
    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null)
            return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null)
            return false;
        if (productScale != null ? !productScale.equals(product.productScale) : product.productScale != null)
            return false;
        if (productVendor != null ? !productVendor.equals(product.productVendor) : product.productVendor != null)
            return false;
        if (productDescription != null ? !productDescription.equals(product.productDescription) : product.productDescription != null)
            return false;
        if (quantityInStock != null ? !quantityInStock.equals(product.quantityInStock) : product.quantityInStock != null)
            return false;
        if (buyPrice != null ? !buyPrice.equals(product.buyPrice) : product.buyPrice != null) return false;
        if (msrp != null ? !msrp.equals(product.msrp) : product.msrp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productCode != null ? productCode.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productScale != null ? productScale.hashCode() : 0);
        result = 31 * result + (productVendor != null ? productVendor.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (quantityInStock != null ? quantityInStock.hashCode() : 0);
        result = 31 * result + (buyPrice != null ? buyPrice.hashCode() : 0);
        result = 31 * result + (msrp != null ? msrp.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productsByProductCode")
    public List<Orderdetail> getOrderdetailsByProductCode() {
        return orderdetailByProductCode;
    }

    public void setOrderdetailsByProductCode(List<Orderdetail> orderdetailByProductCode) {
        this.orderdetailByProductCode = orderdetailByProductCode;
    }

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false)
    public Productline getProductlinesByProductLine() {
        return productlineByProductLine;
    }

    public void setProductlinesByProductLine(Productline productlineByProductLine) {
        this.productlineByProductLine = productlineByProductLine;
    }
}
