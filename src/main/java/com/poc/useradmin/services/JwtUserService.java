package com.poc.useradmin.services;


import com.poc.useradmin.model.AC_Users;
import com.poc.useradmin.model.UserDTO;
import com.poc.useradmin.model.UserExtension;
import com.poc.useradmin.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserExtension loadUserByUsername(String userName) throws UsernameNotFoundException {
        AC_Users user = new AC_Users();
        user = userDao.findByUsername(userName);
//        user = userDao.findByUserId(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                new ArrayList<>());
        UserExtension jwtUserExtension= new UserExtension(user.getUsername(), user.getPassword(), new ArrayList<>());
        jwtUserExtension.setUserId(user.getUserId());
        return jwtUserExtension;
    }

    public AC_Users save(UserDTO user) {
        AC_Users newUser = new AC_Users();
        newUser.setUsername(user.getUsername());
        System.out.println("password ..."+user.getUsername() +" entered password "+user.getPassword());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        System.out.println("password ..."+user.getUsername() +" encrypt password "+user.getPassword());
        return userDao.save(newUser);
    }

    public AC_Users changePwd(UserDTO user, Integer id) {
        System.out.println("user object ..."+user.getUsername()+" password..."+user.getPassword()+" id..."+id);
        AC_Users newUser = new AC_Users();
        newUser.setUsername(user.getUsername());
        newUser.setUserId(id);
        System.out.println("password ..."+user.getUsername() +" entered password "+user.getPassword()+"new password ..."+user.getNewPassword());
//        String password = user.getNewPassword();
        newUser.setPassword(bcryptEncoder.encode(user.getNewPassword()));
        System.out.println("new username  ..."+newUser.getUsername() +" new encrypt password "+newUser.getPassword());
        return userDao.save(newUser);
    }
}