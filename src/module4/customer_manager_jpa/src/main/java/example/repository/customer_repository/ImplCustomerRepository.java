package example.repository.customer_repository;

import example.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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

    @Override
    public void saveProcedure(Customer entity) {
        String jpql = "call insert_customer(?1,?2,?3)";
        StoredProcedureQuery query = em.createStoredProcedureQuery("insert_customer")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .setParameter(1, entity.getName())
                .registerStoredProcedureParameter(2, java.sql.Date.class, ParameterMode.IN)
                .setParameter(2, java.sql.Date.valueOf(entity.getBirthday()))
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .setParameter(3, entity.getImg());
        query.execute();
    }


}
