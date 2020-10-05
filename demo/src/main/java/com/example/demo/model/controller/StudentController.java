package com.example.demo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentServiceImpl;
import com.example.demo.convertor.StudentConvertor;
import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	private final StudentServiceImpl studService;
	
	public StudentController(StudentServiceImpl studService) {
		this.studService=studService;
		
	}

	@GetMapping("/student-with-multiple-address")
	public ResponseEntity<?> checkStudentName() {
		List<Student> studReturned = studService.findStudentWithMultipleAddress();
		List<StudentDTO> studReturned1 = StudentConvertor.entityToDto(studReturned);
		return new ResponseEntity<List<StudentDTO>>(studReturned1, HttpStatus.OK);

	}

}
