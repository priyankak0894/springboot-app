package com.db.mysqltesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.mysqltesting.entity.CollegeStudents;
import com.db.mysqltesting.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studentrepo;
	
	public List<CollegeStudents> getAllStudents()
	{
		 return studentrepo.findAll();
	}
	
	public CollegeStudents getStudentByName(String studname, String studdept)
	{
		return studentrepo.findByStudentnameAndStudentdept(studname,studdept);
	}

	public CollegeStudents saveStudentDetails(String name, int studentid, String studentdept) 
	{
		CollegeStudents cs = new CollegeStudents(name, studentid, studentdept);
		cs.setStudentname(name);
		cs.setStudentid(studentid);
		cs.setStudentdept(studentdept);
		studentrepo.save(cs);
		return studentrepo.findByStudentnameAndStudentdept(name, studentdept);
	}

	public void deleteStudent(int studentid) 
	{
		CollegeStudents studentDetails = studentrepo.findByStudentid(studentid);
		studentrepo.delete(studentDetails);
	}
	
	public CollegeStudents updateStudentDetails(int studentid, CollegeStudents studentDetails) {
        // Find the existing student by ID
        CollegeStudents existingStudent = studentrepo.findByStudentid(studentid);
        
        if (existingStudent != null) {
            // Update fields with new values
            existingStudent.setStudentname(studentDetails.getStudentname());
            existingStudent.setStudentdept(studentDetails.getStudentdept());
            // Update other fields as necessary

            // Save the updated student back to the database
            return studentrepo.save(existingStudent);
        } else {
            // Handle the case where the student does not exist (optional)
            throw new RuntimeException("Student not found for this id :: " + studentid);
        }
	}
}
