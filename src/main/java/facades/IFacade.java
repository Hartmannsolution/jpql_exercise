package facades;

import entity.Customer;
import entity.Employee;
import entity.OrderEntity;

import java.util.List;

public interface IFacade {
    Employee createEmployee(Employee e); // Creates and return a new Employee
    Customer update(Customer c); //Updates and returns the updated Customer
    Customer findCustomer(int id);
    int getEmployeCount(); // return total employees
    List<Employee> getAllEmployees(); // Return a list with all employees
    List<Customer> getCustomersInCity(String city); //  Return all customers living in a given city (Barcelona has 1)
    Employee getEmployeMaxCustomers() ; // Return the employee with most customers (Answer: 1401, Pamela Castillo)
    List<OrderEntity> getOrdersOnHold(); // Return all orderEntity where status is "On Hold"  (Answer: orderNumbers = 10334, 10401, 10407, 10414)
    List<OrderEntity> getOrdersOnHold(int customerNumber); // Return all orderEntity on hold for a given customer (try Customer 144) (Answer: orderNumber=10334)
    List<String> getCustomerNamesSorted(); // Return a list with (only) customerNames sorted ascending

}
