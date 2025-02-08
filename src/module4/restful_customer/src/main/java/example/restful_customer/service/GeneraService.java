package example.restful_customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneraService<A> {
    List<A> findAll();
    A findById(long id);
    A save(A entity);
    void delete(long id);

}
