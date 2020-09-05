package com.poc.useradmin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name="AC_USERS", schema = "FirstMule")
public class AC_Users {

    @Id
    @GeneratedValue
    @Column(name = "User_id")
    private Integer userId;
    @Column(name = "User_name")
    private String username;
    @Column(name = "Password")
    @JsonIgnore
    private String password;
    @Column(name = "Login_Id")
    private String loginId;
    @Column(name = "Mail_Id")
    private String mailId;
    @Column(name = "User_Add_Dt")
    @CreationTimestamp
    private Date createdDate;
    @Column(name = "Last_Login_Dt")
    @UpdateTimestamp
    private Date modifiedDate;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private  String lastName;
    @Column(name = "Display_Name")
   // @JsonIgnore
    private  String displayName;



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column
//    private String username;
//    @Column
//    @JsonIgnore
//    private String password;


    public AC_Users() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}