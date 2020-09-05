package com.poc.useradmin.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.useradmin.model.ACUsers;
import com.poc.useradmin.model.ACUsersList;
import com.poc.useradmin.model.AC_Users;
import com.poc.useradmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

//    public List getUserRoles(Integer id) throws JsonProcessingException {
////        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl = "http://localhost:8082/userroles/users/";
//        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl+id, String.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.getBody());
//
//        JsonNode userId = root.path("userId");
//        JsonNode mapRole = root.path("mappedRole");
//        System.out.println("userid " +userId+ " mapRole "+mapRole);
//        return null;
//    }

    public List<AC_Users> getAllUsers() throws JsonProcessingException {
        List<AC_Users>  users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        System.out.println("all users..."+ users.size());
//        usersLists.stream().filter(user -> user.getUserId()
        return users;
    }

    //retriving by list of user ids-
    public ACUsersList getAllUsersByIds(List<Integer> ids) throws JsonProcessingException {
        List<AC_Users>  users = new ArrayList<>();
        ids.forEach(id -> users.add(getUser(id).get()));
        ACUsersList acUsersList = new ACUsersList();
//        System.out.println("inside user domain>>> "+users.get(0));
        acUsersList.setAcUsersList(users);
        return acUsersList;
    }

    public Optional<AC_Users> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public AC_Users addUser(AC_Users user) {
        System.out.println("display name ..."+user.getDisplayName()+" first name .. "+user.getFirstName());
        return userRepository.save(user);
    }

    public void updateUser(Integer id, AC_Users user) {
        Optional<AC_Users> acUsers = getUser(user.getUserId());
        String password = acUsers.stream().map(x -> x.getPassword()).collect(Collectors.joining());
        System.out.println("password ..."+password);
        user.setPassword(password);
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}

