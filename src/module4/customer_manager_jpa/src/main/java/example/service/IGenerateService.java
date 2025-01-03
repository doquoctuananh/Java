package example.service;

import java.util.List;

public interface IGenerateService<A> {
    List<A> findAll();
    void save(A entity);
    void delete(int id);
    A findById(int id);
    void update(int id,A entity);
}
