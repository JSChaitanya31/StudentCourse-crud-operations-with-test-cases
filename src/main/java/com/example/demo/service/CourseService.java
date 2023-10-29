package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CourseRegistrationNotFoundException;
import com.example.demo.model.CourseRegistration;
import com.example.demo.repo.CourseRepository;

@Service
public class CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
    

	public CourseRegistration saveCourseRegistration(CourseRegistration courseRegistration) {

		return courseRepository.save(courseRegistration);
	}

	public CourseRegistration getCourseRegistrationById(long id) {

		return courseRepository.findById(id)
				.orElseThrow(() -> new CourseRegistrationNotFoundException("Registration Not Found"+id));

	}

	public List<CourseRegistration> getAllCourseRegistration() {

		return courseRepository.findAll();
	}

	
	public CourseRegistration updateCourseRegistration(CourseRegistration updateRequest) {
		
		return courseRepository.save(updateRequest);
	}

	public void deleteCourseRegistration(long id) {

		courseRepository.deleteById(id);
		
	}

}
