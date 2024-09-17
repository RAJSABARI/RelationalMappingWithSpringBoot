package com.kgisl.MysqlRelationalMapping.service;

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
    private Lap lap;

    @Transactional
    public void add(Student st) {

        for (Laptop ll : st.getLaptops()) {
            ll.setStudent(st);
        }

        repo.save(st);

    }

}
