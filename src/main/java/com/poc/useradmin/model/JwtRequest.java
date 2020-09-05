package com.poc.useradmin.model;

import java.io.Serializable;
import java.util.Date;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private Integer userId;
    private String username;
    private String password;
    private String loginId;
    private String mailId;
    private Date createdDate;
    private Date modifiedDate;
    private String firstName;
    private  String lastName;
    private String newPassword;

    public JwtRequest() {
    }

//    public JwtRequest(Integer userId, String username, String password, String loginId, String mailId, Date createdDate, Date modifiedDate, String firstName, String lastName) {
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
//        this.loginId = loginId;
//        this.mailId = mailId;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
