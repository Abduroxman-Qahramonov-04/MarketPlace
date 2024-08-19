package com.example.market_place.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.validation.constraints.Pattern;

import jakarta.validation.constraints.Size;

@Entity(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    private int id;

    @Size(min = 3,message = "Username should have at least 3 letters")
    @JsonProperty("user_name")
    private String username;


    @Size(min = 8,message = "Password should have at least 8 characters")
    @JsonProperty("password")
    private String password;


    @Pattern(regexp = "^[a-zA-Z]{3,}@gmail\\.com$", message = "Email should be at least 3 letters followed by '@gmail.com'")
    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    @Size(min = 2,message = "First name should have at least 3 letters")
    private String firstName;

    @JsonProperty("last_name")
    @Size(min = 2,message = "Last name should have at least 3 letters")
    private String lastName;

    public User() {

    }
    public User(int id,String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
