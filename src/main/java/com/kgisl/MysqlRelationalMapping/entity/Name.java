package com.kgisl.MysqlRelationalMapping.entity;

public class Name {

    String firstname;
    String lastname;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Name() {
    }
    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    
    
}
