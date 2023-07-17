<%@page import="student.model.product"%>
<%@page import="java.util.LinkedList"%>
<%@page import="student.dao.StudentService"%>
<%@page import="student.daoimpl.courseImpl"%>
<%@page import="student.model.adLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="student.db.database"%>
<%@page%>
<%adLogin msg1=(adLogin)request.getSession().getAttribute("msg1");
if(msg1!=null){
	request.setAttribute("msg1", msg1);
}

courseImpl l=new courseImpl(database.getConnection()); 
List <product> courses=l.getAllcourse(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>


</head>

<body class="bg-light">

	<%@include file="navbar2.jsp"%>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">

				<p class="text-center fs-1 ">Course Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Course Id</th>
							<th scope="col">Course Name</th>
							<th scope="col">Course Price</th>

							<th scope="col">Action</th>
						</tr>
					</thead>
					<% if(!courses.isEmpty()){
	  for(product c:courses){%>

					<tbody>
						<tr>
							<th scope="row"><%=c.getCourse_id()%></th>
							<td><%=c.getCourse_name() %></td>
							<td><%=c.getCourse_price() %></td>

							<td><a href="edit_course.jsp" class="btn btn-sm btn-primary">Edit</a>
								<a href="deletecourse?course_id=<%=c.getCourse_id() %>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>
					</tbody>
					</tr>
					
					<%}
  }
  %>



				</table>
				<a href="add_course.jsp"
								class="btn btn-sm btn-success ms-1">Add course</a></td>
			</div>
		</div>
	</div>




</body>
</html>