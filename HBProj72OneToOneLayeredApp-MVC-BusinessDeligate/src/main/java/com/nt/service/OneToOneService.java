package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface OneToOneService {
	public List<StudentDTO>  findAllStudentsAndLibraryMemebershipDetails();
	public  String  register(StudentDTO dto); 
	public  String  removeStudentWithLibrary(int no);

}
