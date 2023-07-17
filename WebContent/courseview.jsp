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
      <th scope="col">Enrollment Date</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      
      <td>
      <a href="edit_course.jsp" class="btn btn-sm btn-primary">Edit</a>
      <a href="" class="btn btn-sm btn-danger ms-1">Delete</a>
      </td>
       
    </tr>
    
  </tbody>
</table>
        </div>
    </div>
    </div>




</body>
</html>