<%@page import="java.util.List"%>
<%@page import="student.model.cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.util.Login"%>
<%@page import="linkcode.ds.Datasource" %>
<%@page import="student.dao.LoginImpl" %>
<%@page import="student.model.product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    ArrayList<cart> cart_list=(ArrayList<cart>) session.getAttribute("cart-list");
    List<cart> cartProduct=null;
    if(cart_list!=null)
    {
    	LoginImpl l=new LoginImpl(Datasource.getConnection());
    	cartProduct=l.getcartproduct(cart_list);
    	request.setAttribute("cart_list", cart_list);
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>
<%@include file="Navbar.jsp"%>
<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ 300 </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">course id</th>
					<th scope="col">course name</th>
					<th scope="col"> course Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			
			<tbody>
			<%
				if (cart_list != null) {
					for (cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getCourse_id()%></td>
					<td><%=c.getCourse_name()%></td>
					
					<td><%= c.getCourse_price()%></td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						
						
							
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td> <a href="delete_controller?Course_id=<%=c.getCourse_id() %>"  class="btn btn-sm btn-primary">Remove</a>
				</tr>

				<%}
					}%>
				
			</tbody>
		</table>
	</div>

</body>
</html>