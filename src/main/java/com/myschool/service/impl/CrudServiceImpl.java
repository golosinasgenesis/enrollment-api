package com.myschool.service.impl;

import com.myschool.repository.GenericRepository;
import com.myschool.service.CrudService;

import java.util.List;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected abstract GenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
