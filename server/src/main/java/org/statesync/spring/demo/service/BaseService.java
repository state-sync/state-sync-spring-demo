package org.statesync.spring.demo.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<PK extends Serializable, T, Repo extends MongoRepository<T, PK>>
        implements ParentServiceInterface<PK, T, Repo> {

    private final Repo repository;

    protected BaseService(Repo repository) {
        this.repository = repository;
    }

    public Repo repository() {
        return repository;
    }

    @Override
    public T findOne(PK id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
