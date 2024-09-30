package com.kgisl.MysqlRelationalMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lno;

    private String lname;

    @Column(nullable = false, unique = true)
    private String serialno; // Ensure this is lowercase for consistency




    

    // @ManyToOne
    // @JoinColumn(name = "rollnumber", referencedColumnName = "rollnumber")
    // @JsonIgnore
    // private Student student;

    // Constructors, getters, setters, and toString methods

    public Laptop(String serialno, String lname, int lno) {
        this.serialno = serialno; // Consistent naming here
        this.lname = lname;
        this.lno = lno;
    }

    public Laptop() {}

    // Getters and Setters
    public int getLno() {
        return lno;
    }

    public void setLno(int lno) {
        this.lno = lno;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSerialno() { // Ensure it's consistently named as 'serialno'
        return serialno;
    }

    public void setSerialno(String serialno) { // Consistent method naming
        this.serialno = serialno;
    }

    // public Student getStudent() {
    //     return student;
    // }

    // public void setStudent(Student student) {
    //     this.student = student;
    // }
}
