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
                  
                  <p class="fs-3 text-center">Edit Course</p>
                  
                  <form action="" method="post">
                     
                     <div class="mb-3">
                          <label class="form-label">Course Id</label>
                          <input type="text" name="stud_id" class="form-control">
                     </div>
                     
                      <div class="mb-3">
                          <label class="form-label">Course Name</label>
                          <input type="text" name="Stud_name" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Course Price</label>
                          <input type="text" name="stud_DOB" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Enrollment Date</label>
                          <input type="text" name="stud_add" class="form-control">
                     </div>
                     
                     
              
                    <button type="submit" class="btn btn-primary col-md-12">Update</button>
                   
                </form>
                  
                  
                  </div>
             
             </div>
         
         </div>
    
    
    </div>
</div>
      

</body>
</html>