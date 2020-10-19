package com.example.arj.DAO;

import java.util.List;

public interface Dao<T> {

    T find(Integer id);

    List<T> findAll();

    T save(T t);

    T update(T t);

}
