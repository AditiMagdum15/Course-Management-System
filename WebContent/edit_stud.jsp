<%@page import="student.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="linkcode.ds.Datasource"%>
<%@page import="student.daoimpl.StudentServiceImpl"%>
<%@page import="student.controller.Studentdata"%>
<%

StudentServiceImpl s=new StudentServiceImpl(Datasource.getConnection());
Student stud_id=(Student)session.getAttribute("stud_id");
out.print("hi");
Student l=s.retriveStudent(stud_id);

%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>


</head>

<body class="bg-light">

<%@include file="Navbar.jsp" %>

<div class="container p-4">
    <div class="row">
         <div class="col-md-6 offset.md.3">
             <div class="card">
                  <div class="card-body">
                  
                  <p class="fs-3 text-center">Edit Student</p>
                  
                  <form action="" method="post">
                     <%if(!l.isEmpty()){
                    	 for(Student a:l){%>
                     }
                     <div class="mb-3">
                          <label class="form-label"> Id</label>
                          <input type="text" name="stud_id" class="form-control">
                     </div>
                     
                      <div class="mb-3">
                          <label class="form-label"> Name</label>
                          <input type="text" name="Stud_name" value="<%=a.getStud_name() %>" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Date of Birth</label>
                          <input type="text" name="stud_DOB"value="<%=a.getStud_DOB()%>"  class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Address</label>
                          <input type="text" name="stud_add" value="<%=a.getStud_add() %>" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Percent</label>
                          <input type="text" name="stud_per"value="<%=a.getStud_per()%>"  class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Course Id</label>
                          <input type="text" name="course_id"value="<%=a.getCourse_id()%>" class="form-control">
                     </div>
                     <div class="mb-3">
                          <label class="form-label">Password</label>
                          <input type="text" name="pass"value="<%=a.getPass()%>" class="form-control">
                     </div>
                     <%}
                     }%>
                     
              
                    <button type="submit" class="btn btn-primary col-md-12">Update</button>
                   
                </form>
                  
                  
                  </div>
             
             </div>
         
         </div>
    
    
    </div>
</div>
      

</body>
</html>