package com.kgisl.MysqlRelationalMapping.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;


public interface Lap extends JpaRepository<Laptop, Integer>{
   
  // List<Laptop> findBystudent_id(int  id);
   // List<Laptop> findBylname(String lname);

    
}
