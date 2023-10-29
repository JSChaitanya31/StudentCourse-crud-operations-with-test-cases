package com.example.demo.controller;

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
	
	@GetMapping("/{id}")
	public CourseRegistration getCourseRegistrationById(@PathVariable long id){
		return courseService.getCourseRegistrationById(id);
	}
	
	@PutMapping("/{id}")
	public CourseRegistration updateCourseRegistration(@RequestBody CourseRegistration updateRequest) {
		return courseService.updateCourseRegistration(updateRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourseRegistration(@PathVariable long id) {
		courseService.deleteCourseRegistration(id);
	}

}
