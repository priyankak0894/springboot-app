package com.db.mysqltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.mysqltesting.entity.CollegeStudents;

@Repository
public interface StudentRepository extends JpaRepository<CollegeStudents,Long>
{
	CollegeStudents findByStudentnameAndStudentdept(String name, String dept);

	CollegeStudents findByStudentid(int studentid);
	
}
