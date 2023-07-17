<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="student.model.adLogin"%>
<%adLogin msg1=(adLogin)request.getSession().getAttribute("msg1");
if(msg1!=null){
	response.sendRedirect("add_stud.jsp");
}
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp" %>
<script>
const courseIdInput = document.getElementById('course_id');
const courseIdError = document.getElementById('course_id_error');

courseIdInput.addEventListener('blur', () => {
  const courseId = courseIdInput.value.trim();
  if (courseId === '') {
    courseIdError.textContent = 'Please enter a course id';
    courseIdInput.classList.add('is-invalid');
  } else if (/^[A-Z]{3}\d{3}$/.test(courseId)) {
    courseIdError.textContent = '';
    courseIdInput.classList.remove('is-invalid');
  } else {
    courseIdError.textContent = 'Invalid course id format (e.g. ABC123)';
    courseIdInput.classList.add('is-invalid');
  }
});

function validateForm() {
  const courseId = courseIdInput.value.trim();
  if (courseId === '') {
    courseIdError.textContent = 'Please enter a course id';
    courseIdInput.classList.add('is-invalid');
    return false;
  } else if (/^[A-Z]{3}\d{3}$/.test(courseId)) {
    courseIdError.textContent = '';
    courseIdInput.classList.remove('is-invalid');
    return true;
  } else {
    courseIdError.textContent = 'Invalid course id format (e.g. ABC123)';
    courseIdInput.classList.add('is-invalid');
    return false;
  }
}
</script>


</head>

<body class="bg-light">

<%@include file="navbar2.jsp" %>

<div class="container p-4">
    <div class="row">
         <div class="col-md-6 offset.md.3">
             <div class="card">
                  <div class="card-body">
                  
                  <p class="fs-3 text-center">Add Student</p>
                  
                  <form action="Studentdata" method="post" onsubmit="return validateForm();">
                     
                     <div class="mb-3">
                          <label class="form-label"> Id</label>
                          <input type="text" name="stud_id" class="form-control">
                     </div>
                     
                      <div class="mb-3">
                          <label class="form-label"> Name</label>
                          <input type="text" name="Stud_name" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Date of Birth</label>
                          <input type="text" name="stud_DOB" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Address</label>
                          <input type="text" name="stud_add" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Percent</label>
                          <input type="text" name="stud_per" class="form-control">
                     </div>
                     
                     <div class="mb-3">
                          <label class="form-label">Course Id</label>
                          <input type="text" name="course_id"class="form-control">
                          <small id="course_id_error" class="text-danger"></small>
                     </div>
                     <div class="mb-3">
                          <label class="form-label">Password</label>
                          <input type="text" name="pass"class="form-control">
                     </div>
                     
                     
              
                    <button type="submit" class="btn btn-primary col-md-12">Submit</button>
                   
                </form>
                  
                  
                  </div>
             
             </div>
         
         </div>
    
    
    </div>
</div>
      

</body>
</html>