package com.kgisl.MysqlRelationalMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kgisl.MysqlRelationalMapping.entity.Student;
import com.kgisl.MysqlRelationalMapping.service.Servicee;

@RestController
@RequestMapping("/api")
public class Controller {
   @Autowired
   private Servicee service;

    @PostMapping("/add")
    public void  add (@RequestBody Student st){
         service.add(st);
    }
     
}
