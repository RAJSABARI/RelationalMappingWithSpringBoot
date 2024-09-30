package com.kgisl.MysqlRelationalMapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    @Column(nullable=false,unique=true)
    private String rollnumber;

    private int mark;
    private String name;
    private int age;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rollnumber", referencedColumnName = "rollnumber") // Creates the foreign key in Laptop
    private List<Laptop> laptops = new ArrayList<>();
    
    public Student() {
    }

    public Student(int age, String gender, int id, int mark, String name, String rollnumber) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.mark = mark;
        this.name = name;
        this.rollnumber = rollnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollno() {
        return rollnumber;
    }

    public void setRollno(String rollno) {
        this.rollnumber = rollno;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    

}
