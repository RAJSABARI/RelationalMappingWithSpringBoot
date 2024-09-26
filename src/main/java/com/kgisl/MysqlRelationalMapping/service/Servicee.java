package com.kgisl.MysqlRelationalMapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;
import com.kgisl.MysqlRelationalMapping.entity.Student;
import com.kgisl.MysqlRelationalMapping.repository.Lap;
import com.kgisl.MysqlRelationalMapping.repository.Repo;

import jakarta.transaction.Transactional;

@Service
public class Servicee {

    @Autowired
    private Repo repo;

    @Autowired
    private Lap lapo;

  

    @Transactional
    public void add(Student st) {

        for (Laptop ll : st.getLaptops()) {
            ll.setStudent(st);
        }

        repo.save(st);

    }

    public List<Student> get() {
        return repo.findAll();
    }
    public List<Student> getAllStudentsWithLaptops() {
        return repo.findAll(); 
    }

    public Laptop laptopById(Long lapId) {
    return lapo.findById(lapId).orElse(null);
    }

    public Student studentById(Long stId) {
        return repo.findById(stId).orElse(null);
    }

    public List<Laptop> getLaptopsByStudentId(Long id){
        return lapo.findBystudent_rollno(id);
    }

    public void updatestudent(Long studentrollnumber,Student student) {
       
      Student stu=repo.findById(studentrollnumber).orElseThrow();
      stu.setName(student.getName());
      stu.setAge(student.getAge());
      stu.setGender(student.getGender());
      stu.setMark(student.getMark());
      repo.save(stu);
    repo.save(student);
      
    }

    public void updatelaptop(Long laptopId, Laptop laptop) {
        Laptop lap=lapo.findById(laptopId).orElseThrow();
        lap.setLname(laptop.getLname());
       lapo.save(lap);
    }

    public List<Laptop> getAllLaptops() {
        return lapo.findAll();
    }

    public List<Student> getStudentByLaptopId(String lname) {
        return lapo.findBylname(lname).stream()
        .map(Laptop::getStudent)
        .distinct() // In case there are multiple laptops with the same name, we avoid duplicate students
        .collect(Collectors.toList());
    }

    public void deleteByLaptopId(Long id) {
       lapo.deleteById(id);
    }

    public void deleteByStudentId(Long id) {
        repo.deleteById(id);
    }

    public void addstudent(Student st) {
        repo.save(st);
    }

    public Laptop createNewLaptopInExisting(Long id, Laptop st) {
        Student stt=repo.findById(id).orElseThrow();
       st.setStudent(stt);
       return lapo.save(st);
    }
    public List<Student> getStudentsByMarkRange(int minMark, int maxMark) {
        return repo.findStudentsByMarkRange(minMark, maxMark);
    }


}
