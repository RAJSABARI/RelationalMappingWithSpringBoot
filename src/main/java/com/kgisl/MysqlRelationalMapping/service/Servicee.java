package com.kgisl.MysqlRelationalMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgisl.MysqlRelationalMapping.entity.Laptop;
import com.kgisl.MysqlRelationalMapping.entity.Student;
import com.kgisl.MysqlRelationalMapping.repository.Lap;
import com.kgisl.MysqlRelationalMapping.repository.Repo;
import java.util.List;
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
       repo.save(student);
    }

    public void updatelaptop(Long laptopId, Laptop laptop) {
        lapo.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return lapo.findAll();
    }

    public Student getStudentByLaptopId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteByLaptopId(Long id) {
       lapo.deleteById(id);
    }

    public void deleteByStudentId(Long id) {
        repo.deleteById(id);
    }



}
