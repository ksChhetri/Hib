package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthenticationDAOImpl2 implements AuthenticationDAO {
 private static final String  CALL_PRO_AUTHENTICATION="{ call PRO_AUTHENTICATION(?,?,?)}";
	@Override
	public String authenticate( String user, String pwd) {
		String result=null;
		 // get Session
		Session ses=HibernateUtil.getSession();
		//get result
		result=ses.doReturningWork(con->{
				CallableStatement cs=null;
				String resultMsg=null;
				//create CallableStatement object 
				cs=con.prepareCall(CALL_PRO_AUTHENTICATION);
				//register OUT parms with JDBC types
				cs.registerOutParameter(3,Types.VARCHAR);
				//set values to IN Params
				cs.setString(1,user);
				cs.setString(2,pwd);
				//execute pl/sql procedure
				cs.execute();
				//gather results from OUT param
				resultMsg=cs.getString(3);
				return resultMsg;
			}//execute(-)
		);
	   return result;
	}//method
	
}// class
