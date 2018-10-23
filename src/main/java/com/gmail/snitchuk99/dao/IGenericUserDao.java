package com.gmail.snitchuk99.dao;

import java.util.List;

public interface IGenericUserDao <T>{

    T getByID(int id);
    List<T> getAll();
    void add(T node);
    void update(T node, int id);
    void delete(int id);

}
