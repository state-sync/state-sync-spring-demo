package org.statesync.spring.demo.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface ParentServiceInterface<PK extends Serializable, T, Repo extends CrudRepository<T, PK>> {

    T save(T entity);

    T findOne(PK id);

    List<T> findAll();

    Repo repository();

    long count();
}
