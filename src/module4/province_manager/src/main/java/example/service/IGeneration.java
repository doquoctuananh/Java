package example.service;

import example.model.Customer;
import example.model.CustomerDTOView;

import java.util.List;

public interface IGeneration<A> {
    List<A> findAll();
    A findById(long id);
    void save(A entity);
    void delete(long id);
    void update(A entity);
    CustomerDTOView viewCustomer(long id);

}
