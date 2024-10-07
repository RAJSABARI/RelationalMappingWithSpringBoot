package com.kgisl.MysqlRelationalMapping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
   
  // List<Laptop> findBystudent_id(int  id);
   // List<Laptop> findBylname(String lname);

    
}
