package com.poc.useradmin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.useradmin.model.ACUsers;
import com.poc.useradmin.model.ACUsersList;
import com.poc.useradmin.model.AC_Users;
import com.poc.useradmin.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserServices userService;

    // TEST OK
    @RequestMapping("/users")
    public List<AC_Users> getAllAdminUsers() throws JsonProcessingException {
        System.out.println("Inside get users method");
        return userService.getAllUsers();
    }

    // TEST OK
    @RequestMapping("/users/{id}")
    public Optional<AC_Users> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    // TEST OK
    @RequestMapping("/users/_list/{id}")
    public ACUsersList getUserList(@PathVariable List<Integer> id) throws JsonProcessingException {
        return userService.getAllUsersByIds(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/users")
    public void addUser(@RequestBody AC_Users user) {
        System.out.println("controller display name ..."+user.getDisplayName()+" first name .. "+user.getFirstName());
        userService.addUser(user);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/users/{id}")
    public void updateUser(@RequestBody AC_Users user, @PathVariable Integer id) {
        System.out.println("Inside update method id "+id);
        System.out.println("user id ...."+user.getUserId()+"  password..."+user.getPassword());
        userService.updateUser(id, user);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

