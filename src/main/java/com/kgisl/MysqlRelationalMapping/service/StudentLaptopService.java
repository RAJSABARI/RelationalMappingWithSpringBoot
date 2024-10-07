package com.kgisl.MysqlRelationalMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.MysqlRelationalMapping.daoa.CriteriaQueriesForListOfLaptops;
import com.kgisl.MysqlRelationalMapping.daoa.JdbcRepo;
import com.kgisl.MysqlRelationalMapping.entity.Laptop;
import com.kgisl.MysqlRelationalMapping.entity.Student;
import com.kgisl.MysqlRelationalMapping.repository.LaptopRepository;
import com.kgisl.MysqlRelationalMapping.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.transaction.Transactional;

@Service
public class StudentLaptopService {

    @Autowired
    private StudentRepository studentrepo;

    @Autowired
    private LaptopRepository lapo;
    
    
    @Autowired
    private JdbcRepo jdbc;
    
    
    @Autowired
    private CriteriaQueriesForListOfLaptops cqlistoflaptops;
    
    
    @Transactional
    public void add(Student student) {

        // First, save the Student entity
        studentrepo.save(student);
        // Now save the Laptop entities (this will set the foreign key automatically)
        List<Laptop> laptops = student.getLaptops();
        if (laptops != null && !laptops.isEmpty()) {
            for (Laptop laptop : laptops) {
                lapo.save(laptop); // Save each laptop associated with the student
            }
        }

        // Now save the Laptop entities, if any exist
        // if (student.getLaptops() != null && !student.getLaptops().isEmpty()) {
        //     for (Laptop laptop : student.getLaptops()) {
        //         laptop.setStudent(student); // Set the Student reference in each Laptop
        //         lapo.save(laptop);    // Save each Laptop entity
        //     }
        // } else {
        // }
    }

    public List<Student> get() {
        //return studentrepo.findAll();
    	return jdbc.getAllStudentsWithLaptops();
    }

    public List<Student> getAllStudentsWithLaptops() {
        return studentrepo.findAll();
    	//return jdbc.getAllStudentsWithLaptops();
    }

    public Laptop laptopById(int lapId) {
        return lapo.findById(lapId).orElse(null);
    }

    public Student studentById(int stId) {
        return studentrepo.findById(stId).orElse(null);
    }

    public List<Laptop> getLaptopsByStudentId(int id) {
        // Fetch the student by id
        Student student = studentrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

// Return the list of laptops for the student
        return student.getLaptops();
    }

    public void updatestudent(int id, Student student) {

        Student stu = studentrepo.findById(id).orElseThrow();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setGender(student.getGender());
        stu.setMark(student.getMark());
        studentrepo.save(stu);
        studentrepo.save(student);

    }

    public void updatelaptop(int laptopId, Laptop laptop) {
        Laptop lap = lapo.findById(laptopId).orElseThrow();
        lap.setLname(laptop.getLname());
        lapo.save(lap);
    }
    private static final Logger logger = LoggerFactory.getLogger(StudentLaptopService.class);
    public List<Laptop> getAllLaptops() {
        //return lapo.findAll();
    	  if (cqlistoflaptops == null) {
              logger.error("cqlistoflaptops is null!");
          }
          return cqlistoflaptops.getAllLaptops();
      //  return cqlistoflaptops.getAllLaptops();
    }

    // public List<Student> getStudentByLaptopId(String lname) {
    //     return lapo.findBylname(lname).stream()
    //     .map(Laptop::getStudent)
    //     .distinct() // In case there are multiple laptops with the same name, we avoid duplicate students
    //     .collect(Collectors.toList());
    // }
    public void deleteByLaptopId(int id) {
        lapo.deleteById(id);
    }

    public void deleteByStudentId(int id) {
        studentrepo.deleteById(id);
    }

    // public void addstudent(Student st) {
    //     studentrepo.save(st);
    // }
    public Laptop createNewLaptopInExisting(int id, Laptop st) {
        // Student stt = studentrepo.findById(id).orElseThrow();
        // st.setStudent(stt);
        // return lapo.save(st);
        // Fetch the existing student by id
        Student student = studentrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

// Add the new laptop to the student's list of laptops
        student.getLaptops().add(st);

// Save the student (will automatically save the new laptop)
        studentrepo.save(student);

        return st;
    }

    public List<Student> getStudentsByMarkRange(int minMark, int maxMark) {
        return studentrepo.findStudentsByMarkRange(minMark, maxMark);
    }
}
