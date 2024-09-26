package com.kgisl.MysqlRelationalMapping.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;


public interface Lap extends JpaRepository<Laptop, Long>{
   
   List<Laptop> findBystudent_rollno(Long  rollno);
   List<Laptop> findBylname(String lname);

    
}
