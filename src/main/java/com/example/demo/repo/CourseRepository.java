package com.example.demo.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CourseRegistration;

@Repository
public interface CourseRepository extends JpaRepository<CourseRegistration, Long> { 
	
	List<CourseRegistration> findByRegistrationDateBetween(Date startDate, Date endDate);

}
