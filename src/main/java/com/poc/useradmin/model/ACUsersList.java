package com.poc.useradmin.model;

import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

public class ACUsersList {

    List<AC_Users> acUsersList = new ArrayList<>();

    public List<AC_Users> getAcUsersList() {
        return acUsersList;
    }

    public void setAcUsersList(List<AC_Users> acUsersList) {
        this.acUsersList = acUsersList;
    }
}
