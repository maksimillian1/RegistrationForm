package com.gmail.snitchuk99.entity;

public class UserProfile {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String login;
    private String password;

    public UserProfile(String firstName, String lastName, String dateOfBirth, String login, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserProfile[" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ']';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValueByFieldName(String key){
        switch (key){
            case "firstName":
                return getFirstName();
            case "lastName":
                return getLastName();
            case "dateOfBirth":
                return getDateOfBirth();
            case "login":
                return getLogin();
            case "password":
                return getPassword();
        }
        throw new IllegalArgumentException("No such field!");
    }

}
