package com.example.swaggerexample.model;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(notes = "Name of de User")
    private String userName;
    
    @ApiModelProperty(notes = "Salary of de User")
    private Long salary;

    public User(String userName, long salary) {
        this.userName = userName;
        this.salary = salary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
