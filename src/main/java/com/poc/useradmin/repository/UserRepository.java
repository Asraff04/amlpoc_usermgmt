package com.poc.useradmin.repository;

import com.poc.useradmin.model.ACUsers;
import com.poc.useradmin.model.AC_Users;
import com.poc.useradmin.model.AC_Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AC_Users, Integer> {
    public AC_Users findByUsername(String username);
    public AC_Users findByUserId(String username);
}
