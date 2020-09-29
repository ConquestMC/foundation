package com.conquestmc.foundation.player;

import java.util.List;

public interface DataDriver<T>
{
    T findById(Object id);
    T findByOne(String key, Object value);
    T findByTwo(String key, Object value, String keyTwo, Object valueTwo);
    T findByThree(String key, Object value, String keyTwo, Object valueTwo, String keyThree, Object valueThree);
    List<T> findAll();
    void create(T object);
    void update(T object);
    void delete(T object);
}