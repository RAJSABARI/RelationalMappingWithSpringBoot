package com.kgisl.MysqlRelationalMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.MysqlRelationalMapping.entity.Student;


@Repository
public interface  Repo extends JpaRepository<Student, Long>{
    
}
