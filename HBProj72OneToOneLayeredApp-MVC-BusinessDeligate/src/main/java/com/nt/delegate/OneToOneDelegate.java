package com.nt.delegate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.nt.commons.DataRetrievingException;
import com.nt.commons.DeletionIssueException;
import com.nt.commons.StudentAlreadyRegisteredException;
import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.OneToOneService;
import com.nt.service.OneToOneServiceFactory;
import com.nt.vo.LibraryMembershipVO;
import com.nt.vo.StudentVO;

public class OneToOneDelegate {
	
	public List<StudentDTO>  getAllStudentsAndLibraryMembershipDetailsDelegate()throws DataRetrievingException{
		OneToOneService service=null;
		List<StudentDTO> listDTO=null;
		//get SErvie class object
		service=OneToOneServiceFactory.getInstance();
		try{
			listDTO=service.findAllStudentsAndLibraryMemebershipDetails();
		}
		catch(Exception e){
			throw new DataRetrievingException(e.getMessage());
		}
		return listDTO;
	}//method
	public String   registerDelegate(StudentVO stVO)throws StudentAlreadyRegisteredException,ParseException{
		OneToOneService service=null;
		String result=null;
		LibraryMembershipVO libVO=null;
		StudentDTO stDTO=null;
		LibraryMembershipDTO libDTO=null;
		//convert StVO class object stDTO class object
		libVO=stVO.getLibraryDetails();
		libDTO=new LibraryMembershipDTO();
		libDTO.setDoj(new SimpleDateFormat("MM-dd-yyyy").parse(libVO.getDoj()));
		stDTO=new StudentDTO();
		stDTO.setSname(stVO.getSname());
		stDTO.setSadd(stVO.getSadd());
		stDTO.setLibraryDetails(libDTO);
		libDTO.setStudentDetails(stDTO);
		//get Service class object
		service=OneToOneServiceFactory.getInstance();
		try{
			result=service.register(stDTO);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new StudentAlreadyRegisteredException(e.getMessage());
		}
		return result;
	}//method
	public String   deleteStudentWithLibraryDelegate(String no)throws DeletionIssueException{
		OneToOneService service=null;
		String result;
		int sno=0;
		//get Service  class
		service=OneToOneServiceFactory.getInstance();
		//convert  Student number to int
		sno=Integer.parseInt(no);
		//use Service class
		try{
		result=service.removeStudentWithLibrary(sno);
		}
		catch(Exception e){
			throw new  DeletionIssueException(e.getMessage());
		}
		return result;
	}//method
}//class
