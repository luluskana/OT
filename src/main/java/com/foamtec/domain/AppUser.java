package com.foamtec.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by apichat on 1/19/2017 AD.
 */
@Entity
@Table(name="APP_USER")
public class AppUser implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @Column(name="createBy")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="updateDate")
    private Date updateDate;

    @Column(name="updateBy")
    private String updateBy;

    @Column(name="employeeID")
    private String employeeID;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="sex")
    private String sex;

    @Column(name="department")
    private String department;

    @Column(name="emailAddress")
    private String emailAddress;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="roleName")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
