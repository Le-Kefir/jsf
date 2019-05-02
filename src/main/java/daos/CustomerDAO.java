package daos;

import entities.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer save(Customer customer) {
        entityManager.persist(customer);

        return customer;
    }

    public Customer getCustomer(int id) {
        return entityManager.find(Customer.class ,id);
    }

    public List<Customer> getCustomers() {
        Query query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);

        return query.getResultList();
    }

}
