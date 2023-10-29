package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.CourseRegistration;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@WebMvcTest(CourseController.class)
class CourseControllerTest {
	
	@MockBean
	CourseService courseService;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	public void test_saveCourseRegistration() throws Exception {
		CourseRegistration courseRegistration = new CourseRegistration(100L,"abc","abc@gmail.com","testcase");
        when(courseService.saveCourseRegistration(courseRegistration)).thenReturn(courseRegistration);
        mockMvc.perform(post("/registrations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(courseRegistration)))
                .andExpect(status().isOk());	
	}
	
	@Test
    public void test_getCourseRegistrationById() throws Exception {
		CourseRegistration courseRegistration = new CourseRegistration(100L,"abc","abc@gmail.com","testCase");
        when(courseService.getCourseRegistrationById(100L)).thenReturn(courseRegistration);
        mockMvc.perform(get("/registrations/{id}",100L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               .andExpect(jsonPath("$.studentName").value("abc"));
	}
	
	 @Test
	 public  void test_getAllCourseRegistration() throws Exception {
		 when(courseService.getAllCourseRegistration()).thenReturn(Stream.of(new CourseRegistration((long) 21, "rob", "rob@gmail.com","react"), new CourseRegistration((long) 22, "bran", "bran@gmail.com", "jscript")).collect(Collectors.toList()));
		 mockMvc.perform(get("/registrations")
		 .contentType(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andExpect(jsonPath("$[0].studentName").value("rob"));


	    }

}
