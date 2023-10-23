package facades;
import entity.Customer;
import entity.Employee;
import entity.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade implements IFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @Override
    public Employee createEmployee(Employee e) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Integer> tq = em.createQuery("SELECT MAX(e.employeeNumber) FROM Employee e", Integer.class);
        int lastId = tq.getSingleResult();
        e.setEmployeeNumber(lastId+1);
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return e;
        } finally {
            em.close();
        }
    }

    @Override
    public Customer update(Customer c) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
            return c;
        } finally {
            em.close();
        }
    }

    @Override
    public Customer findCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public int getEmployeCount() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Integer> tq = em.createQuery("SELECT COUNT(e) FROM Employee e", Integer.class);
        return tq.getSingleResult();
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return tq.getResultList();
    }

    @Override
    public List<Customer> getCustomersInCity(String city) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer c WHERE c.city = :city", Customer.class);
        tq.setParameter("city", city);
        return tq.getResultList();
    }

    @Override
    public Employee getEmployeMaxCustomers() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<OrderEntity> getOrdersOnHold() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<OrderEntity> getOrdersOnHold(int customerNumber) {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<String> getCustomerNamesSorted() {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
