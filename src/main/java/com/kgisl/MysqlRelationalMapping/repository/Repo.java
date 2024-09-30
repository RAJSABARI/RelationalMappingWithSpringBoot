package com.kgisl.MysqlRelationalMapping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.MysqlRelationalMapping.entity.Student;


@Repository
public interface  Repo extends JpaRepository<Student, Integer >{
     @Query("SELECT s FROM Student s WHERE s.mark BETWEEN :minMark AND :maxMark")
    List<Student> findStudentsByMarkRange(int minMark, int maxMark);
   // Optional<Student> findById(int id);
}
