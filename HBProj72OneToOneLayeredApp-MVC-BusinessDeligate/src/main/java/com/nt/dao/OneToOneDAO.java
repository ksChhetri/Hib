package com.nt.dao;

import java.util.List;

import com.nt.domain.Student;

public interface OneToOneDAO {
	public List<Student>  getAllStudentsAndTheirLibraryMembershipDetails();
	public  int  insertStudentWithLibrary(Student student);
	public  int  deleteStudentWithLibary(int no); 
}
