package com.db.mysqltesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.mysqltesting.entity.CollegeStudents;
import com.db.mysqltesting.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "StudentAPIs")

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@Operation(summary = "Get all students")
	@GetMapping("/getStudents")
	public List<CollegeStudents> getAllStudents() {
		return studentService.getAllStudents();

	}

	@Operation(summary = "Get student by name and department")
	@GetMapping("/getByStudentName")
	public CollegeStudents getStudentByName(@RequestParam String name, @RequestParam(name = "dpt") String studentdept) {
		return studentService.getStudentByName(name, studentdept);
	}

	@Operation(summary = "Save the student details")
	@PostMapping("/saveStudentDetails")
	public CollegeStudents saveStudentDetails(@RequestParam String name, @RequestParam(name = "studentid") int studentid, 
			@RequestParam(name = "dpt") String studentdept, @RequestBody List<CollegeStudents> studentList) 
	{
		return studentService.saveStudentDetails(name, studentid,studentdept);
	}
	
	@Operation(summary = "Delete the student details")
	@DeleteMapping("/deleteStudentById/{studentid}") 
	public void deleteStudentDetails(@PathVariable (value = "studentid") int sId) 
	{
		studentService.deleteStudent(sId);
	}
	
	@Operation(summary = "Update the student details")
	@PutMapping("/updateStudentById/{studentid}")
	public ResponseEntity<CollegeStudents> updateStudentDetails(
	        @PathVariable(value = "studentid") int studentid,
	        @RequestBody CollegeStudents studentDetails) {
	    CollegeStudents updatedStudent = studentService.updateStudentDetails(studentid, studentDetails);
	    return ResponseEntity.ok(updatedStudent);
	}
	
}
