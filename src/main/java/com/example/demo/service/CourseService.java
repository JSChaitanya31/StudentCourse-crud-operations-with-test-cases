package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	
	public CourseRegistration updateCourseRegistration(long id, CourseRegistration updateToDB ) {
		
//		CourseRegistration updateToDB = courseRepository.findById(id).orElseThrow();
		return courseRepository.save(updateToDB);
	}
  
	public void deleteCourseRegistration(long id) {

		courseRepository.deleteById(id);
		
	}
	
	public List<CourseRegistration> sortBasedUponSomeField(String field) {
        return courseRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }
	
	public Page<CourseRegistration> getRegistrationWithPagination(int offset, int pageSize) {
        return courseRepository.findAll(PageRequest.of(offset, pageSize));

    }
	
	public Page<CourseRegistration> getRegistrationWithPaginationAndSorting(int offset, int pageSize, String field) {
        return courseRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));

	}
	
	public List<CourseRegistration> getRegistrationsByRegistrationDate(Date startDate, Date endDate) {
        return courseRepository.findByRegistrationDateBetween(startDate, endDate);

    }

}
