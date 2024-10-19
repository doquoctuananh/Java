package module2.test.service;

public interface IPerson<E> {
    void created(E e);
    void update(E e);
    void delete(E e);
}
