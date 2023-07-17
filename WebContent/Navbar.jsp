<%@page import="student.controller.LoginController" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Student Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="float:right">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="student.view.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add_stud.jsp"> Student</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="cart.jsp">cart</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="course_list.jsp"> course list</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="delete_controller"> Log out</a>
        </li>
      </ul>
      
    </div>
  </div>
</nav>
    