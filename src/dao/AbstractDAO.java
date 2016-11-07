package dao;

import java.util.Set;

public interface AbstractDAO<T> {
    T save(T t);
    void delete(T t);
    void deleteAll(Set<T> t);
    void saveAll(Set<T> t);
    Set<T> getAll();
}
