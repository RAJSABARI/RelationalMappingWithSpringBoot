package com.kgisl.MysqlRelationalMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Long lno;
    private String lname;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student_rollno")
    private Student student;

    public Laptop() {
    }

    public Laptop(String lname, Long lno) {
        this.lname = lname;
        this.lno = lno;
    }

    public Long getLno() {
        return lno;

    }

    public void setLno(Long lno) {
        this.lno = lno;
    }

    public String getLname() {
        return lname;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
