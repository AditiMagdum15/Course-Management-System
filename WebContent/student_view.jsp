<%@page import="javax.activation.DataSource"%>
<%@page import="student.model.Student"%>
<%@page import="student.model.adLogin"%>
<%@page import="student.daoimpl.StudentServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import = "student.db.database" %>
<%@page import="linkcode.ds.Datasource" %> 
<%@page %> 
<%adLogin msg1=(adLogin)request.getSession().getAttribute("msg1");
	if(msg1!=null){
		request.setAttribute("msg1", msg1);
	}
	  
StudentServiceImpl l=new StudentServiceImpl(database.getConnection());  
List<Student> students=l.getAllStudent();
%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>


</head>	

<body class="bg-light">

    <%@include file="navbar2.jsp" %>
    
    
    
    <div class="container p-5">
         <div class="card">
              <div class="card-body">
          
    <p class="text-center fs-1 ">All Student Details</p>
         <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Date of Birth</th>
      <th scope="col">Address</th>
      <th scope="col">Percent</th>
      <th scope="col">Course Id</th>
      <th scope="col">Password</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <% if(!students.isEmpty()){
	for(Student s:students){%>
	<tbody>
    <tr>
      <th scope="row"><%=s.getStud_id() %></th>
      <td><%=s.getStud_name() %></td>
      <td><%=s.getStud_DOB() %></td>
      <td><%=s.getStud_add() %></td>
      <td><%=s.getStud_per() %></td>
      <td><%=s.getCourse_id() %></td>
      <td><%=s.getPass() %></td>
      
      <td>
      <a href="edit_stud.jsp?stud_id=<%=s.getStud_id() %>" class="btn btn-sm btn-primary">Edit</a>
      <%session.setAttribute("stud_id", s.getStud_id()); %>
      <a href="deletecontroller" class="btn btn-sm btn-danger ms-1">Delete</a>
      </td>
      </tbody>
    </tr>
    <%}	
  }
  
 %>     
      
    
  
</table>
<a href="add_stud.jsp"
								class="btn btn-sm btn-success ms-1">Add student</a></td>
        </div>
    </div>
    </div>




</body>
</html>