package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;

public class OneToOneServiceImpl implements OneToOneService {

	@Override
	public List<StudentDTO> findAllStudentsAndLibraryMemebershipDetails() {
		OneToOneDAO  dao=null;
		List<Student> listDomains=null;
		LibraryMembership lib=null;
		List<StudentDTO> listDTO=null;
		StudentDTO  studDTO=null;
		LibraryMembershipDTO libDTO=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//use DAO
		listDomains=dao.getAllStudentsAndTheirLibraryMembershipDetails();
		//Convert ListDomains to ListDTO
		listDTO=new ArrayList();
		for(Student st:listDomains){
			studDTO=new StudentDTO();
			studDTO.setSno(st.getSno());
			studDTO.setSname(st.getSname());
			studDTO.setSadd(st.getSadd());
			lib=st.getLibraryDetails();
			libDTO=new LibraryMembershipDTO();
			libDTO.setLid(lib.getLid());
			libDTO.setDoj(lib.getDoj());
          studDTO.setLibraryDetails(libDTO);
          libDTO.setStudentDetails(studDTO);
          listDTO.add(studDTO);
		}//for
		return listDTO;
	}//method
	
	@Override
	public String register(StudentDTO dto) {
		OneToOneDAO dao=null;
		Student  st=null;
		LibraryMembership lib=null;
		LibraryMembershipDTO libDTO=null;
		int sno=0;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//Convert DTO to Domain class object
		 st=new Student();
		 st.setSname(dto.getSname());
		 st.setSadd(dto.getSadd());
		 libDTO=dto.getLibraryDetails();
		 lib=new LibraryMembership();
		 lib.setDoj(libDTO.getDoj());
		 st.setLibraryDetails(lib);
		 lib.setStudentDetails(st);
		//use DAO
		sno=dao.insertStudentWithLibrary(st);
		return "Student is registred with sno="+sno;
	}//method
	
	@Override
	public String removeStudentWithLibrary(int no) {
		OneToOneDAO dao=null;
		int count=0;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//use DAO
		count=dao.deleteStudentWithLibary(no);
		if(count==0)
				return "Student  with Library is not deleted";
		else
			return "Student with Library is deleted";
	}//method
}//class
