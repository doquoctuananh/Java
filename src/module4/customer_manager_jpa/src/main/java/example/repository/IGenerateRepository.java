package example.repository;

import java.util.List;

public interface IGenerateRepository<A> {
    List<A> findAll();
    void save(A entity);
    void delete(int id);
    A findById(int id);
    void update(int id,A entity);
}
