package com.db.mysqltesting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "collegestudents")
public class CollegeStudents 
{
	@Id
	private int id;
	
	private String studentname;
	private int studentid;
	private String studentdept;
	
	public CollegeStudents(int id, String studentname, int studentid, String studentdept) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.studentid = studentid;
		this.studentdept = studentdept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentdept() {
		return studentdept;
	}
	public void setStudentdept(String studentdept) {
		this.studentdept = studentdept;
	}
	public CollegeStudents() {
		super();
	}
	public CollegeStudents(String name, int studentid2, String studentdept2) {
	}
	
	
	
}
