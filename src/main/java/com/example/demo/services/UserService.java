package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service //this annotation creates this class as a
// bean and exposes it to the application context.
public class UserService {
    //so i'm injecting the UsersRepository
    @Autowired
    private UserRepository userRepository;
    //then a method to insert a new user.
    //User here carries all the fields of the user entity/model since we are creating a user
    public void createClient(User user){
        //but first we hash the password for security purposes.
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        //creating roles
        Role userRole = new Role("CLIENT");//we create a role type client
        //a user can then take a list of roles
        List<Role> roles = new ArrayList<>();//list of roles
        roles.add(userRole);//add client role type to the list
        user.setRoles(roles);//set a user to a role type
        userRepository.save(user);//save the user to the database.
    }
    public void createSupplier(User user){
        //but first we hash the password for security purposes.
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        //creating roles
        Role userRole = new Role("SUPPLIER");//we create a role type client
        //a user can then take a list of roles
        List<Role> roles = new ArrayList<>();//list of roles
        roles.add(userRole);//add client role type to the list
        user.setRoles(roles);//set a user to a role type
        userRepository.save(user);//save( save is a crudrepository method) the user to the database.
    }
    //a method to just return one user
    public User findOne(Long id){
        //findById is a CrudRepository method. it replaced findOne CrudRepostory method in earlier spring boot versions
        return userRepository.findById(id).orElse(null);//define this method in the repository
    }

}
