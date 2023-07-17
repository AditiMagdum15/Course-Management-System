<%@page import="student.model.adLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%adLogin msg1=(adLogin)request.getSession().getAttribute("msg1");
	if(msg1!=null){
		request.setAttribute("msg1", msg1);
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="navbar2.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset.md.3">
				<div class="card">
					<div class="card-body">
					<p class="fs-3 text-center">Admin Login</p>
						<form action="admin_log_controller">
						
							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="text" id="form2Example1" class="form-control" name="unm" />
								<label class="form-label" for="form2Example1">User name</label>
							</div>

							<!-- Password input -->
							<div class="form-outline mb-4">
								<input type="password" id="form2Example2" class="form-control" name="pass"/>
								<label class="form-label" for="form2Example2">Password</label>
							</div>

							<!-- 2 column grid layout for inline styling -->
							<div class="row mb-4">
								<div class="col d-flex justify-content-center">
									<!-- Checkbox -->
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="form2Example31" checked /> <label
											class="form-check-label" for="form2Example31">
											Remember me </label>
									</div>
								</div>

								<div class="col">
									<!-- Simple link -->
									<a href="forget.jsp">Forgot password?</a>
								</div>
							</div>

							<!-- Submit button -->
							<button type="submit" class="btn btn-primary btn-block mb-4">Sign
								in</button>

							<!-- Register buttons -->
							<div class="text-center">
								<p>
									Not a member? <a href="register.jsp">Register</a>
								</p>
								
								
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-facebook-f"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-google"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-twitter"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-github"></i>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>