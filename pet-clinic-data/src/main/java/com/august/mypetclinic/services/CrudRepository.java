package com.august.mypetclinic.services;

import java.util.Set;

public interface CrudRepository<T, ID> {

    T save(T entity);

    T findById(ID id);

    Set<T> finAll();

    void deleteById(ID id);

    void delete(T entity);

}
