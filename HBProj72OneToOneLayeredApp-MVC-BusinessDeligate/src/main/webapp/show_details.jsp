<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 
  <c:choose>
    <c:when test="${!empty listDTO}">
        <c:forEach var="st" items="${listDTO}">
           <h2 style="color:red"> ${st.sno} &nbsp;&nbsp;&nbsp; ${st.sname} &nbsp;&nbsp;&nbsp; ${st.sadd} &nbsp;&nbsp;<a href="controller?param=link2&sno=${st.sno}">Delete student with Library </a> </h3> 
           <h5 style="color:blue">${st.libraryDetails.lid}&nbsp;&nbsp;&nbsp; ${st.libraryDetails.doj} &nbsp;&nbsp; <a href="controller?param=link3">Delete only Library </a></h4>
        </c:forEach>
          <a href="register_student_with_library.jsp">Add Student with LibraryMembership</a>
    </c:when>
    <c:otherwise>
          <h1 style="color:red">Records not found </h1>
    </c:otherwise>
  </c:choose>
  <br><br><br>
  <c:if test="${result ne null }">
     <h1 style='color:cyan'>${result} </h1>
  </c:if>
  
 
