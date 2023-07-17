<%@page import="student.controller.LoginController"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Student Management System</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp">Home</a></li>
				<%
					if (msg1 != null) {
				%>
				

				<li class="nav-item"><a class="nav-link"
					href="student_view.jsp">student list</a></li>

				<li class="nav-item"><a class="nav-link" href="course_view.jsp">
						course list</a></li>
				<li class="nav-item"><a class="nav-link"
					href="deletecontroller"> Logout</a></li>

				<%
					} else {
				%>
				<li class="nav-item"><a class="nav-link"
					href="admin_log_controller"> Login</a></li>
				<%
					}
				%>

			</ul>

		</div>
	</div>
</nav>
