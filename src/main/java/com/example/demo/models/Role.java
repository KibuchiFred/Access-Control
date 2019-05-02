package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Roles")
public class Role {

    //will be used to map a user to a role. the primary key of the class
    @Id
    private String role;
    //a list of users having a role
    //a many to amny relationship generates a third table whose columns are the primary
    // keys of the classes that created the relationship
    @ManyToMany(mappedBy = "roles")
    private List<User> user;

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //a constructor for both fields.
    public Role(String role, List<User> user) {
        this.role = role;
        this.user = user;
    }

    //a role name constructor
    public Role(String role) {
        this.role = role;
    }

    //default constructor
    public Role() {
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

