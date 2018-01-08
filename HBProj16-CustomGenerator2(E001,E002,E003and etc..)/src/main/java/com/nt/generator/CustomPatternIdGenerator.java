package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomPatternIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  int val=0;
		  //get connection object
		  try{
		  con=session.getJdbcConnectionAccess().obtainConnection();
		  ps=con.prepareStatement("select EID_SEQ_GEN.nextVal from dual");
		  rs=ps.executeQuery();
		  if(rs.next()){
			 val=rs.getInt(1);  
		   }
		  if(val<10)
			  return "E00"+val;
		  else if(val<100)
			  return "E0"+val;
		  else
			  return "E"+val;
		  }//try
		  catch(SQLException se){
			  se.printStackTrace();
			  return "Could not generate Id value";
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  return "Could not generatd Id value";
		  }
		  finally{
			  //close jdbc objs
			  try{
				 if(rs!=null)
					 rs.close();
			  }
			  catch(SQLException se){
				  se.printStackTrace();
			  }
			  try{
					 if(ps!=null)
						 ps.close();
				  }
				  catch(SQLException se){
					  se.printStackTrace();
				  }
			  try{
					 if(con!=null)
						 con.close();
				  }
				  catch(SQLException se){
					  se.printStackTrace();
				  }
		  }//finally
		  
	}//generate(-,-)
}//class
