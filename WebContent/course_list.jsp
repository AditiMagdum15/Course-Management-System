<%@page import="student.model.adLogin"%>
<%@page import="student.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.util.Login"%>
<%@page import="linkcode.ds.Datasource"%>
<%@page import="student.dao.LoginImpl"%>
<%@page import="student.model.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	adLogin msg1 = (adLogin) request.getSession().getAttribute("msg1");
	if (msg1 != null) {
		request.setAttribute("msg1", msg1);
	}

	LoginImpl l = new LoginImpl(Datasource.getConnection());
	List<product> products = l.getallproducts();
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>


</head>

<body class="bg-light">

	<%@include file="Navbar.jsp"%>



	<div class="container p-5">
		<div class="card">
			<div class="card-body">

				<p class="text-center fs-1 ">All Course Details</p>
				<table class="table">

					<thead>

						<tr>
							<th scope="col">Course Id</th>
							<th scope="col">Course Name</th>
							<th scope="col">Course Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<%
						if (!products.isEmpty()) {
							for (product p : products) {
					%>
					<tbody>
						<tr>
							<th scope="row"><%=p.getCourse_id()%></th>
							<td><%=p.getCourse_name()%></td>
							<td><%=p.getCourse_price()%></td>


							<td><a
								href="add_cart_controller?Course_id=<%=p.getCourse_id()%>"
								class="btn btn-sm btn-primary" onclick="enroll()">Enroll</a></td>
					</tbody>
					

					<%
						}

						}
					%>

					</tbody>
				</table>
			</div>
		</div>
	</div>




</body>
<script>
	function enroll() {
		alert("course added to cart");
	}
</script>
</html>