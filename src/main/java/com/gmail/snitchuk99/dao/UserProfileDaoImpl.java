package com.gmail.snitchuk99.dao;

import com.gmail.snitchuk99.entity.UserProfile;
import com.gmail.snitchuk99.util.PropertyManager;

import java.sql.*;
import java.util.*;

public class UserProfileDaoImpl implements IGenericUserDao<UserProfile>  {

    private static final String configDBPath = "/home/paimon/IdeaProjects/RegistrationForm/src/main/resources/dbconfig.resources";

    private static Connection con;
    private static PropertyManager pm = new PropertyManager();

    private final String FIND_BY_ID = "SELECT * FROM userProfiles WHERE id=?";
    private final String FIND_ALL = "SELECT * FROM userProfiles";
    private final String FIND_BY_LOGIN ="SELECT * FROM userProfiles WHERE login=?";
    private final String INSERT = "INSERT INTO userProfiles(firstName, lastName, dateOfBirth, login, password) VALUES(?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE userProfiles SET firstName=?, lastName=?, dateOfBirth=?, login=?, password=? WHERE id=?";
    private final String DELETE = "DELETE FROM userProfiles WHERE id=?";
    private final String DELETE_ALL = "DELETE FROM userProfiles";

    private final Map<Integer, String> userProfileFields = new HashMap<Integer, String>(){{
        put(1, "firstName");
        put(2, "lastName");
        put(3, "dateOfBirth");
        put(4, "login");
        put(5, "password");
    }};


    static {
        String url;
        String login;
        String password;
        try {
            pm.setPath(configDBPath);
            url = pm.getProperty("url");
            login = pm.getProperty("login");
            password = pm.getProperty("password");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            con = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserProfile getByID(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(FIND_BY_ID);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            rs.next();
            return resultSetToUserProfile(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private UserProfile resultSetToUserProfile(ResultSet rs) throws SQLException{
        for (Map.Entry<Integer, String> urs:userProfileFields.entrySet()) {

        }
        String firstName = rs.getString(userProfileFields.get(1));
        String lastName = rs.getString(userProfileFields.get(2));
        String dateOfBirth = rs.getString(userProfileFields.get(3));
        String login = rs. getString(userProfileFields.get(4));
        String password = rs.getString(userProfileFields.get(5));
        return new UserProfile(firstName, lastName, dateOfBirth, login, password);
    }

    public static void main(String[] args) {
        UserProfileDaoImpl updi = new UserProfileDaoImpl();
        updi.add(new UserProfile("Nicola", "Tesla", "28/01/1980", "tesla290", "nic1980"));
        System.out.println(updi.getByID(2).toString());
    }

    @Override
    public List<UserProfile> getAll() {
        try{
            List<UserProfile> users = new ArrayList<>();
            PreparedStatement preparedStatement = con.prepareStatement(FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                users.add(resultSetToUserProfile(rs));
            }
            return users;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(UserProfile userProfile) {
        try {
            PreparedStatement pr = con.prepareStatement(INSERT);
            setStringsInStatement(userProfile, pr);
            pr.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void setStringsInStatement(UserProfile userProfile, PreparedStatement pr) throws SQLException {
        for (Map.Entry<Integer, String> urs:userProfileFields.entrySet()) {
            pr.setString(urs.getKey(), userProfile.getValueByFieldName(urs.getValue()));
        }
    }

    @Override
    public void update(UserProfile userProfile, int id) {
        try {
            PreparedStatement pr = con.prepareStatement(UPDATE);
            setStringsInStatement(userProfile, pr);
            pr.setInt(userProfileFields.size(), id);
            pr.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pr = con.prepareStatement(DELETE);
            pr.setInt(1, id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
