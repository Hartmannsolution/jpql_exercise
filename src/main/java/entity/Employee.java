package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;
    private List<Customer> customerByEmployeeNumber;
    private Office officeByOfficeCode;
    private Employee employeeByReportsTo;
    private List<Employee> employeeByEmployeeNumber;

    public Employee() {
    }

    public Employee(String lastName, String firstName, String extension, String email, String jobTitle) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.jobTitle = jobTitle;
    }

    @Id
    @Column(name = "employeeNumber")
    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeNumber != null ? !employeeNumber.equals(employee.employeeNumber) : employee.employeeNumber != null)
            return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (extension != null ? !extension.equals(employee.extension) : employee.extension != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (jobTitle != null ? !jobTitle.equals(employee.jobTitle) : employee.jobTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeNumber != null ? employeeNumber.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeesBySalesRepEmployeeNumber")
    public List<Customer> getCustomersByEmployeeNumber() {
        return customerByEmployeeNumber;
    }

    public void setCustomersByEmployeeNumber(List<Customer> customerByEmployeeNumber) {
        this.customerByEmployeeNumber = customerByEmployeeNumber;
    }

    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false)
    public Office getOfficesByOfficeCode() {
        return officeByOfficeCode;
    }

    public void setOfficesByOfficeCode(Office officeByOfficeCode) {
        this.officeByOfficeCode = officeByOfficeCode;
    }

    @ManyToOne
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
    public Employee getEmployeesByReportsTo() {
        return employeeByReportsTo;
    }

    public void setEmployeesByReportsTo(Employee employeeByReportsTo) {
        this.employeeByReportsTo = employeeByReportsTo;
    }

    @OneToMany(mappedBy = "employeesByReportsTo")
    public List<Employee> getEmployeesByEmployeeNumber() {
        return employeeByEmployeeNumber;
    }

    public void setEmployeesByEmployeeNumber(List<Employee> employeeByEmployeeNumber) {
        this.employeeByEmployeeNumber = employeeByEmployeeNumber;
    }
}
