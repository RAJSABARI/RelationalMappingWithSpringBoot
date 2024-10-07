package com.kgisl.MysqlRelationalMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;
import com.kgisl.MysqlRelationalMapping.entity.Student;
import com.kgisl.MysqlRelationalMapping.service.StudentLaptopService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controller {

	@Autowired
	private StudentLaptopService service;

	@PostMapping("/post") // used to add student and multiple laptops and without sending laptop used to
							// add only student
	public void add(@RequestBody Student st) {
		service.add(st);
	}

	// @PostMapping("/postNewStudent")
	// public void addstudent(@RequestBody Student st){
	// service.addstudent(st)
	// }

	@GetMapping("/filter")
	public List<Student> getStudentsByMarkRange(@RequestParam int minMark, @RequestParam int maxMark) {
		return service.getStudentsByMarkRange(minMark, maxMark);
	}

	@PostMapping("/createNewLaptopInExisting/{id}")
	public Laptop createNewLaptopInExisting(@PathVariable int id, @RequestBody Laptop st) {
		return service.createNewLaptopInExisting(id, st);
	}

	@GetMapping("/getAllStudents") // used to getallstudents
	public List<Student> student() {
		return service.get();
	}

	@GetMapping("/getAllLaptops") // used to getallLaptops
	public List<Laptop> getAllLaptops() {
		return service.getAllLaptops();
	}

	@GetMapping("/students-with-laptops")
	public List<Student> getAllStudentsWithLaptops() {
		return service.getAllStudentsWithLaptops();
	}

	@GetMapping("/laptopById/{id}") // used to getspecific laptop using id
	public Laptop laptopById(@PathVariable("id") int lapId) {
		return service.laptopById(lapId);
	}

	@GetMapping("/studentById/{id}") // used to getspecific student using id
	public Student studentById(@PathVariable("id") int stId) {
		return service.studentById(stId);
	}

	@GetMapping("/sId/{id}") // used display the laptops specific studentid
	public List<Laptop> getLaptopsByStudentId(@PathVariable("id") int lapId) {
		return service.getLaptopsByStudentId(lapId);
	}

	// @GetMapping("/lId/{lapName}") //used display the student specific laptopid
	// public List<Student> getStudentByLaptopId(@PathVariable String lapName) {
	// return service.getStudentByLaptopId(lapName);
	// }

	@PutMapping("/updatestudent/{id}") // used to update specific student
	public void updatestudent(@PathVariable("id") int id, @RequestBody Student student) {
		service.updatestudent(id, student);
	}

	@PutMapping("/updatelaptop/{id}") // used to update specific laptops
	public void updatelaptop(@PathVariable("id") int laptopId, @RequestBody Laptop laptop) {
		service.updatelaptop(laptopId, laptop);
	}

	@DeleteMapping("/deleteByLaptopId/{id}") // used to delete specificLaptop
	public void deleteByLaptopId(@PathVariable("id") int id) {
		service.deleteByLaptopId(id);
	}

	@DeleteMapping("/deleteByStudentId/{id}") // used to delete specificStudent
	public void deleteByStudentId(@PathVariable("id") int id) {
		/*
		 * this is parent database cannot delete but using orphanRemoval = true in
		 * student entity class it makes easier when we delete specific student it also
		 * delete in laptop table
		 */
		service.deleteByStudentId(id);
	}
}
