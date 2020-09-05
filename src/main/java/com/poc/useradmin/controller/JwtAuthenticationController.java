package com.poc.useradmin.controller;


import com.poc.useradmin.configuration.JwtTokenUtil;
import com.poc.useradmin.model.JwtRequest;
import com.poc.useradmin.model.JwtResponse;
import com.poc.useradmin.model.UserDTO;
import com.poc.useradmin.model.UserExtension;
import com.poc.useradmin.services.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {


        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        System.out.println("user name .."+authenticationRequest.getUsername()+" password ... "+authenticationRequest.getPassword());
        final UserExtension userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
//        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        System.out.println("inside register... "+user.getUsername()+"  password ... "+user.getPassword());
        return ResponseEntity.ok(userDetailsService.save(user));
    }
    //
    @RequestMapping(value = "/changepwd/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> savePwd(@RequestBody UserDTO user, @PathVariable Integer id) throws Exception {
        authenticate(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(userDetailsService.changePwd(user, id));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


//    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
//    public ResponseEntity<?> changePassword(@RequestBody UserDTO user) throws Exception {
//
//        //  if(authenticate(user.getUsername(), user.getPassword())){
////                saveUser(user);
////            }
////        System.out.println("user name .."+authenticationRequest.getUsername()+" password ... "+authenticationRequest.getPassword());
////        final UserExtension userDetails = userDetailsService
////                .loadUserByUsername(authenticationRequest.getUsername());
//
//
////        Private boolean isMatchPwd = isPasswordsMatch(authenticationRequest.getPassword(), userDetailsService.getPassword());
//
//        // return ResponseEntity.ok(new JwtResponse(token));
//        return null;
//    }

//    public boolean isPasswordsMatch(String newPassword, String passwordFromDb) {
//       if(passwordFromDb.equals(newPassword)){
//
//       }

//    }
}
