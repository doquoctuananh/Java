package example.repository;

import java.util.List;

public interface IGenerateRepository<A> {
    List<A> findAll();
    void save(A entity);
    void delete(int id);
    void findById(int id);
}
