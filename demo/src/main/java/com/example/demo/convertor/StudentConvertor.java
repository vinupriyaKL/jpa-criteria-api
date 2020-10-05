package com.example.demo.convertor;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;

public class StudentConvertor {

	public static StudentDTO entityToDto(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setEmail(student.getEmail());
		dto.setFirstName(student.getFirstName());
		dto.setGrade(student.getGrade());
		dto.setId(student.getId());
		dto.setLastName(student.getLastName());
		dto.setPhone(student.getPhone());
		dto.setTotalMarks(student.getTotalMarks());
		dto.setAddressDetails(student.getAddressDetails());
		dto.setJoiningDate(student.getJoiningDate());

		return dto;

	}

	public static Student dtoToEntity(StudentDTO dto) {
		Student entity = new Student();

		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setGrade(dto.getGrade());
		entity.setId(dto.getId());
		entity.setLastName(dto.getLastName());
		entity.setPhone(dto.getPhone());
		entity.setTotalMarks(dto.getTotalMarks());
		entity.setAddressDetails(dto.getAddressDetails());
		entity.setJoiningDate(dto.getJoiningDate());

		return entity;

	}

	public static List<StudentDTO> entityToDto(List<Student> student) {
		return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public static List<Student> dtoToEntity(List<StudentDTO> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

	}
}
