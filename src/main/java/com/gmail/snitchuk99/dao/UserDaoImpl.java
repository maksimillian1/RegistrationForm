package com.gmail.snitchuk99.dao;

import com.gmail.snitchuk99.entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private static Connection connection;
    private static Statement statement;
    private static FileInputStream fis;
    private static Properties properties = new Properties();

    private static final String DELETE = "DELETE FROM dataExample WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM dataExample";
    private static final String FIND_BY_ID = "SELECT * FROM dataExample WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";
    private static final String INSERT = "INSERT INTO dataExample(name, surname, age) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";

    private static final String userName = "name";
    private static final String userSurname = "surname";
    private static final String userAge = "age";


    static{
        String url;
        String login;
        String password;
        try {
            fis = new FileInputStream(new File("/home/paimon/IdeaProjects/RegistrationForm/src/main/resources/dbconfig.resources"));
            properties.load(fis);
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            url = properties.getProperty(ConfigKeys.url);
            login = properties.getProperty(ConfigKeys.login);
            password = properties.getProperty(ConfigKeys.password);
            connection = DriverManager.getConnection(url, login, password);
        }catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement pr = connection.prepareStatement(FIND_ALL);
        ResultSet rs = pr.executeQuery();
        while (rs.next()){
            users.add(resultSetToUser(rs));
        }
        return users;
    }

    public User getByID(int id) throws SQLException{
        PreparedStatement pr = connection.prepareStatement(FIND_BY_ID);
        pr.setInt(1, id);
        ResultSet resultSet = pr.executeQuery();
        if (resultSet.next()){
            return resultSetToUser(resultSet);
        }else {
            throw new NoSuchElementException();
        }
    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(userName);
        String surname = resultSet.getString(userSurname);
        int age = resultSet.getInt(userAge);
        return new User(name, surname, age);
    }

    public List<User> getByName(String name) {

        return null;
    }

    public Boolean add(User user) {
        try {
            PreparedStatement pr = connection.prepareStatement(INSERT);
            pr.setString(1, user.getName());
            pr.setString(2, user.getSurname());
            pr.setInt(3, user.getAge());
            pr.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(int id) {
        return null;
    }

    public int delete(int id) throws SQLException{
        PreparedStatement pr = connection.prepareStatement(DELETE);
        pr.setInt(1, id);
        return pr.executeUpdate();
    }

    public static void closeConnection(){
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
