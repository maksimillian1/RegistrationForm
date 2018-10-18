package com.gmail.snitchuk99.dao;

import com.gmail.snitchuk99.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll() throws SQLException;

    User getByID(int id) throws SQLException;

    List<User> getByName(String name);

    Boolean add(User user);

    Boolean update(int id);

    int delete(int id) throws SQLException;


}
