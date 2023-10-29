package com.example.demo.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.CourseRegistration;
import com.example.demo.repo.CourseRepository;


@SpringBootTest
class CourseServiceTest {

	@MockBean
	CourseRepository courseRepository;
	
	@Autowired
    CourseService courseService;



	
	@Test
	public void test_saveCourseRegistration(){
		CourseRegistration courseRegistration =new CourseRegistration((long) 100, "abc", "abc@gmail.com", "testCase");
		when(courseRepository.save(courseRegistration)).thenReturn(courseRegistration);
		assertEquals(courseRegistration, courseService.saveCourseRegistration(courseRegistration));
	}
	
	@Test
	public void test_getCourseRegistrationById() {
		CourseRegistration courseRegistration =new CourseRegistration((long) 100, "abc", "abc@gmail.com", "testCase");
		when(courseRepository.findById((long) 100)).thenReturn(Optional.of(courseRegistration));
		assertEquals("abc@gmail.com",courseService.getCourseRegistrationById(100).getStudentEmail());
	}
	
	@Test
	public void test_getAllCourseRegistration(){
		when(courseRepository.findAll()).thenReturn(Stream.of(new CourseRegistration((long) 21, "rob", "rob@gmail.com","react"), new CourseRegistration((long) 22, "bran", "bran@gmail.com", "jscript")).collect(Collectors.toList()));
		assertEquals(2, courseService.getAllCourseRegistration().size());
			}
	
//	@Test
//	public void test_deleteCourseRegistrationById() {
//		CourseRegistration courseRegistration = new CourseRegistration((long) 100, "abc", "abc@gmail.com", "testCase");
//		courseService.deleteCourseRegistration(courseRegistration);
//		verify(courseRepository,times(2).delete());
//		}
}
