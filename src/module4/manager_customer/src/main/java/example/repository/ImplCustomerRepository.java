package example.repository;

import example.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class ImplCustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        String jpql = "SELECT c FROM Customer c";
        String hql= "from Customer c";
        TypedQuery<Customer> query = em.createQuery(jpql,Customer.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(Customer customer) {
        em.persist(customer);
    }
}
