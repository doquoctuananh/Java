package example.repository.customer_repository;

import example.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ImplCustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        String jpql="select c from Customer c";
        TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer entity) {
        em.persist(entity);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Customer.class, id));
    }

    @Override
    public Customer findById(int id) {
        return em.find(Customer.class, id);
    }

    @Override
    public void update(int id, Customer entity) {
        entity.setId(id);
        em.merge(entity);
    }


}
