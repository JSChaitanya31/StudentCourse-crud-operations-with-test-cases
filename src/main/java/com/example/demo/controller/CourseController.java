package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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


import com.example.demo.model.CourseRegistration;
import com.example.demo.service.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/registrations")
public class CourseController {
	
	@Autowired
	
	
	private CourseService courseService;
	
	@PostMapping
	public CourseRegistration saveCourseRegistration(@RequestBody CourseRegistration courseRegistration) {
		return courseService.saveCourseRegistration(courseRegistration);
		}
	
	@GetMapping
	public List<CourseRegistration> getAllCourseRegistration(){
		return courseService.getAllCourseRegistration();
	}
	
	
	@GetMapping("/sort/{field}")
	public List<CourseRegistration> sortRegistrations(@PathVariable String field){
		return courseService.sortBasedUponSomeField(field);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<CourseRegistration> paginationRegistrations(@PathVariable int offset,@PathVariable int pageSize){
		return courseService.getRegistrationWithPagination(offset, pageSize);
	}
	
	@GetMapping("/paginationandSorting/{offset}/{pageSize}/{field}")
	public Page<CourseRegistration> paginationAndSorting(@PathVariable int offset,@PathVariable int pageSize, @PathVariable String field){
		return courseService.getRegistrationWithPaginationAndSorting(offset, pageSize, field);
	}
	
	@GetMapping("/{id}")
	public CourseRegistration getCourseRegistrationById(@PathVariable long id){
		return courseService.getCourseRegistrationById(id);
	}
	
	@PutMapping("/{id}")
	public CourseRegistration updateCourseRegistration(@PathVariable Long id, @RequestBody CourseRegistration courseRegistration) {
		return courseService.updateCourseRegistration(id, courseRegistration);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourseRegistration(@PathVariable long id) {
		courseService.deleteCourseRegistration(id);
	}
	
	@GetMapping("/dData")
	public List<CourseRegistration> getRegistrationsByRegistrationDate(@RequestParam Date startDate, @RequestParam Date endDate){
		return courseService.getRegistrationsByRegistrationDate(startDate, endDate);
	}

}
