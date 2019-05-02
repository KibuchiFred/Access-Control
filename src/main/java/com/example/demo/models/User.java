package com.example.demo.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Users")
public class User {

    //fields to be presented to the user as view. form fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String userRole;
    @NotEmpty
    private String username;
    @NotEmpty
    //@Size(min = 4, max = 16)
    @Column(length = 255)
    private String password;
    @NotEmpty
    private String confirmPassword;

    //a list of roles
    //Many users can have the same role and also a many roles can be shared by one user.
    @ManyToMany(cascade = CascadeType.ALL)
    //defining the tables details, we set the name of the third table to USER_ROLES.
    // next define how pri-key field is called and tell spring jpa the specific
    @JoinTable(name="USER_ROLES", joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "role")})
    private List<Role> roles;

    //default constructor
    public User(){

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}

