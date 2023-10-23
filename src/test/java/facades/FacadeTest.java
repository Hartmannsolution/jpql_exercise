package facades;
import entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    IFacade facade = new Facade();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createEmployee() {
        System.out.println("Create Employee");
        Employee expected = new Employee("Hansen", "Helge", "0x2222", "hh@mail.dk", "admin");
        Employee actual = facade.createEmployee(expected);
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        System.out.println("");
    }

    @Test
    void findCustomer() {
        System.out.println("");
    }

    @Test
    void getEmployeCount() {
        System.out.println("");
    }

    @Test
    void getAllEmployees() {
        System.out.println("");
    }

    @Test
    void getCustomersInCity() {
        System.out.println("");
    }

    @Test
    void getEmployeMaxCustomers() {
        System.out.println("");
    }

    @Test
    void getOrdersOnHold() {
        System.out.println("");
    }

    @Test
    void testGetOrdersOnHold() {
        System.out.println("");
    }

    @Test
    void getCustomerNamesSorted() {
        System.out.println("");
    }
}